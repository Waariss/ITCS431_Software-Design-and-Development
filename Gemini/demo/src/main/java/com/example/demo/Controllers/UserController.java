package com.example.demo.Controllers;

import com.example.demo.Models.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    //done
    @GetMapping("/")
    public String login() {
        return "login";
    }
    //done
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @GetMapping("/home")
    public String homepage() {
        return "Home";
    }
    @GetMapping("/error")
    public String errorpage() {
        return "Error";
    }
    //done
    @GetMapping("/admin")
    public String getAllUsers(Model model) {
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/admin/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        Optional<User> user = Optional.ofNullable(userService.findById(id));
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    //done
    @DeleteMapping("/admin/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted");
    }
    // done
    @PutMapping("/admin/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody Map<String, Object> body) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        // Update user properties
        user.setUsername((String) body.get("username"));
        user.setPassword((String) body.get("password"));
        user.setEmail((String) body.get("email"));
        user.setFirstName((String) body.get("firstName"));
        user.setLastName((String) body.get("lastName"));
        user.setRole((String) body.get("role"));
        userService.save(user);
        return ResponseEntity.ok("User updated");
    }
    // done
    @PostMapping("/admin/adduser")
    public ResponseEntity<?> addUser(@RequestParam Map<String, Object> body, Model model) {
        User newUser = createUser(body);
        if (userService.existsByUsername(newUser.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(0); // Conflict (409) status code
        }
        userService.save(newUser);
        return ResponseEntity.status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, "/admin")
                .build();
    }
    //done
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam Map<String, Object> body, Model model) {
        User newUser = createUser(body);
        if (userService.existsByUsername(newUser.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(0); // Conflict (409) status code
        }
        userService.save(newUser);
        return ResponseEntity.status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, "/")
                .build();
    }
    //done
    @PostMapping("login")
    public @ResponseBody ResponseEntity<?> login(@RequestParam(value = "username") String username,
                                                 @RequestParam(value = "password") String password,
                                                 HttpServletResponse response) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            if (user.getRole().equals("Astronomer")) {
                return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, "home").build();
            } else if (user.getRole().equals("Administrator")) {
                return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, "admin").build();
            }
            return ResponseEntity.ok(user.getUId()); // OK (200) status code for other roles
        }
        return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, "error").build();
    }
    //done
    private User createUser(Map<String, Object> body) {
        String username = body.get("username") != null ? body.get("username").toString() : null;
        String password = body.get("password") != null ? body.get("password").toString() : null;
        String email = body.get("email") != null ? body.get("email").toString() : null;
        String firstName = body.get("firstName") != null ? body.get("firstName").toString() : null;
        String lastName = body.get("lastName") != null ? body.get("lastName").toString() : null;
        String role = body.get("role") != null ? body.get("role").toString() : null;
        return new User(0, username, password, email, firstName, lastName, role);
    }
}
