package com.service.loginService.model;

import javax.persistence.*;

@Entity
@Table(name = "user_creds")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean active;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
