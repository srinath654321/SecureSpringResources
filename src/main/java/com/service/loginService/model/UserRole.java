package com.service.loginService.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String role;
    @ManyToOne
    @JoinColumn(name = "FK_userId")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
