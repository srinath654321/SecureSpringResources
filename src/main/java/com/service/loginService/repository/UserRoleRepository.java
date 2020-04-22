package com.service.loginService.repository;

import com.service.loginService.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findAllById(int id);
}
