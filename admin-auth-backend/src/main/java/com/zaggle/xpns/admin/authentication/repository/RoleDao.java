package com.zaggle.xpns.admin.authentication.repository;

import com.zaggle.xpns.admin.authentication.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface RoleDao extends JpaRepository<Role, String> {

    Optional<Role> findByName(String name);
}
