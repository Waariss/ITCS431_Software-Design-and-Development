package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    // OG code give by Teacher
//    @GetMapping("/add")
//    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
//        User n = new User();
//        n.setName(name);
//        n.setEmail(email);
//        userRepository.save(n);
//        return "Saved";
//    }
    // New code to try add user by html form
    @GetMapping("/add")
    public String addNewUser(@RequestParam String name, @RequestParam String email, Model model) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/users")
    public String greeting(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}
