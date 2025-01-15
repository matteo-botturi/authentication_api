package fr.mb.auth.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.validator.routines.EmailValidator;

public class EmailConstraintValidator implements ConstraintValidator<ValidEmailAddress, String> {

    private final EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        // Return false if email is null or invalid
        return email != null && emailValidator.isValid(email);
    }
}