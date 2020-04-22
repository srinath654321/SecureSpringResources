package com.service.loginService.repository;

import com.service.loginService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLogInDetailsRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
