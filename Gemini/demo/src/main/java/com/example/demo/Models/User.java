package com.example.demo.Models;

import lombok.Data;
import jakarta.persistence.*;
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uId;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String role;

    public User(int uId, String username, String password, String email, String firstName, String lastName, String role) {
        this.uId = uId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public User() {

    }

    public int getUId() {
        return uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
}

