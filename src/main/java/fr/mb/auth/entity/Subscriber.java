package fr.mb.auth.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "subscriber")
public class Subscriber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscriber_id")
	private Integer subscriberId;

	@Column(nullable = false, unique = true, length = 25)
	private String username;

	@Column(nullable = false, unique = true)
	private String email;

	@Size(max = 255)
	@Column(name = "hashed_password", nullable = false)
	private String hashedPassword;

	@Min(value = 0, message = "Login attempts cannot be negative")
	@Column(name = "login_attempts", nullable = false)
	private Integer loginAttempts;

	@FutureOrPresent(message = "FreezeUntil must not be in the past")
	@Column(name = "freeze_until")
	private LocalDateTime freezeUntil;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false, nullable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "role_id")
	private Role role;
	
	public void assignRole(Role role) {
	    this.role = role;
	}
	
	public boolean isAccountLocked() {
	    return loginAttempts >= 3 && freezeUntil != null && freezeUntil.isAfter(LocalDateTime.now());
	}
}