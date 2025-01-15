package fr.mb.auth.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import fr.mb.auth.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByRoleName(String roleName);
}