package com.service.loginService.resource;

import com.service.loginService.annotations.AppUser;
import com.service.loginService.annotations.IsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String sayWelcome(){
        userService.createUser();
        return "<h1>WELCOME</h1>";

    }

    @AppUser @IsAdmin
    @GetMapping("/user")
    public String helloUser() {
        return "<h1>HELLO USER !!!</h1>";
    }

    @IsAdmin
    @GetMapping("/admin")
    public String helloAdmin() {
        return "<h1>HELLO ADMIN</h1>";
    }
}
