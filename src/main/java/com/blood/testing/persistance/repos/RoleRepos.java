package com.blood.testing.persistance.repos;

import com.blood.testing.persistance.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepos extends JpaRepository<Role,Integer> {
    @Query
    Role findByRoleName(String role_name);
}
