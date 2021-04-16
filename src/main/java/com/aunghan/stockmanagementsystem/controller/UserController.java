package com.aunghan.stockmanagementsystem.controller;

import com.aunghan.stockmanagementsystem.entity.User;
import com.aunghan.stockmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public User login(@RequestParam("username") String username, @RequestParam("password") String password){
        if(username.isEmpty() || password.isEmpty()) return null;
        User user = service.getUserByUsername(username);
        if(user == null) return null;
        if(!user.getPassword().equals(password)) return null;

        String token = UUID.randomUUID().toString();
        user.setToken(token);

        return service.saveUser(user);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        String token = UUID.randomUUID().toString();
        user.setToken(token);

        return service.saveUser(user);
    }

    @PostMapping("/logout")
    public String logout(@RequestParam("username") String username){
        User user = getUserByUsername(username);
        if(user == null) return "No user found";
        user.setToken("");
        service.saveUser(user);
        return "User logged out";
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id){
        return service.getUserById(id);
    }

    @GetMapping(value = "", params = "username")
    public User getUserByUsername(@RequestParam String username){
        if(username == null || username.isEmpty())
            return null;
        return service.getUserByUsername(username);
    }

    @GetMapping(value = "", params = "email")
    public User getUserByEmail(@RequestParam String email){
        if(email == null || email.isEmpty())
            return null;
        return service.getUserByEmail(email);
    }

    @GetMapping("")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping("")
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return service.setActiveStatus(id, false);
    }
}
