package com.example.demo.Service;

import com.example.demo.Models.User;

import java.util.List;

public interface UserService {
    User findById(int id);

    List<User> findAll();

    User findByUsername(String username);

    boolean existsByUsername(String username);

    User save(User user);

    void deleteById(int id);
}
