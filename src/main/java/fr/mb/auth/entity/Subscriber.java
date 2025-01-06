package fr.mb.auth.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "subscriber")
public class Subscriber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscriber_id")
	private Integer subscriberId;

	@NonNull
	@NotBlank
	@Size(min = 5, max = 25)
	@Column(nullable = false, unique = true, length = 25)
	private String username;

	@NonNull
	@NotBlank
	@Email
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@NonNull
	@NotBlank
	@Size(max = 255)
	@Column(name = "hashed_password", nullable = false)
	private String hashedPassword;

	@Min(0)
	@Column(name = "login_attempts", nullable = false)
	private Integer loginAttempts = 0;

	@Column(name = "freeze_until")
	private LocalDateTime freezeUntil;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false, nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt = LocalDateTime.now();

	@NotNull
	@NonNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

}