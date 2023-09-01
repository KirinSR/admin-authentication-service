package com.zaggle.xpns.admin.authentication.repository;

import com.zaggle.xpns.admin.authentication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserDao extends JpaRepository<User, String> {
    Optional<User> findByUserName(String username);
}
