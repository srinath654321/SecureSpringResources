package com.service.loginService.resource;

import com.service.loginService.model.User;
import com.service.loginService.model.UserRole;
import com.service.loginService.repository.UserLogInDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    private UserLogInDetailsRepository userLogInDetailsRepository;

    public void createUser() {
        User user = new User();
        user.setActive(true);
        user.setUsername("jumbo");
        user.setPassword("jam");
        UserRole userRole1 = new UserRole();
        userRole1.setRole("ROLE_USER");
        userRole1.setUser(user);
        UserRole userRole = new UserRole();
        userRole.setRole("ROLE_ADMIN");
        userRole.setUser(user);
        user.setUserRole(Arrays.asList(userRole1, userRole));
        userLogInDetailsRepository.save(user);
    }
}
