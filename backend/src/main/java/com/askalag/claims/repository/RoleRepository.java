package com.askalag.claims.repository;

import com.askalag.claims.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName (String name);
}
