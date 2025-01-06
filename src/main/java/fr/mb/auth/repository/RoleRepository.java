package fr.mb.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.mb.auth.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);
}