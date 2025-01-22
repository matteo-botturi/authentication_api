package fr.mb.auth.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import fr.mb.auth.entity.Role;
import fr.mb.auth.enumeration.RoleName;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;

@DataJpaTest
@AutoConfigureEmbeddedDatabase
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;
    
    @Test
    @Order(1)
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void testCreateRole() {
        Role newRole = new Role(RoleName.ROLE_MODERATOR);
        Role savedRole = roleRepository.save(newRole);
        assertThat(savedRole.getRoleId()).isNotNull();
        assertThat(savedRole.getRoleName()).isEqualTo(RoleName.ROLE_MODERATOR);
    }

    @Test
    @Order(2)
    public void testRolesAreLoadedCorrectly() {
        assertThat(roleRepository.findAll()).hasSize(3);
        assertThat(roleRepository.findByRoleName(RoleName.ROLE_USER)).isPresent();
        assertThat(roleRepository.findByRoleName(RoleName.ROLE_MODERATOR)).isPresent();
        assertThat(roleRepository.findByRoleName(RoleName.ROLE_ADMIN)).isPresent();
    }
}