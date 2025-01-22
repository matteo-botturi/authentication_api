package fr.mb.auth.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import fr.mb.auth.entity.Role;
import fr.mb.auth.enumeration.RoleName;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByRoleName(RoleName roleName);
}