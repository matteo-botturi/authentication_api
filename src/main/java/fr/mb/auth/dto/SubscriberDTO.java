package fr.mb.auth.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriberDTO {
	
    private Integer subscriberId;
    private String username;
    private String email;
    private String hashedPassword;
    private Integer loginAttempts;
    private LocalDateTime freezeUntil;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private RoleDTO role;
    
}