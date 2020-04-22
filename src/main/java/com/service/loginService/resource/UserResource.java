package com.service.loginService.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @GetMapping("/")
    public String sayWelcome(){
        return "<h1>WELCOME</h1>";
    }

    @GetMapping("/user")
    public String helloUser() {
        return "<h1>HELLO USER !!!</h1>";
    }

    @GetMapping("/admin")
    public String helloAdmin() {
        return "<h1>HELLO ADMIN</h1>";
    }
}
