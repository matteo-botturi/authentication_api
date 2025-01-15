package fr.mb.auth.dto;

import fr.mb.auth.validation.RegexPatterns;
import fr.mb.auth.validation.ValidEmailAddress;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubscriberRequestDTO {
	
	@NotBlank(message = "Username is required")
	@Pattern(regexp = RegexPatterns.USERNAME_PATTERN, message = "Username must only contain letters, numbers, points and underscores")
	@Size(min = 5, max = 25, message = "Username must be between 5 and 25 characters")
    private String username;

    @NotBlank(message = "Email is required")
	@ValidEmailAddress
	@Size(max = 255, message = "Email must not exceed 255 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 25, message = "Password must be between 8 and 25 characters")
    @Pattern(regexp = RegexPatterns.PASSWORD_PATTERN, message = "Password must include a lowercase letter, an uppercase letter, a number, and a special character")
    private String password;
}