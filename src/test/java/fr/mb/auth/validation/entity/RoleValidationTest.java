package fr.mb.auth.validation.entity;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import fr.mb.auth.entity.Role;
import fr.mb.auth.enumeration.RoleName;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

class RoleValidationTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void whenRoleNameIsValid_thenNoConstraintViolations() {
        Role role = new Role(RoleName.ROLE_USER);
        var violations = validator.validate(role);
        assertThat(violations).isEmpty();
    }

    @Test
    public void whenRoleNameIsNull_thenConstraintViolation() {
        Role role = new Role(null);
        var violations = validator.validate(role);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("must not be null");
    }
}