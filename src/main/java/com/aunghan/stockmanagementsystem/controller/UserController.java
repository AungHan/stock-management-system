package com.aunghan.stockmanagementsystem.controller;

import com.aunghan.stockmanagementsystem.entity.User;
import com.aunghan.stockmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id){
        return service.getUserById(id);
    }

    @GetMapping(value = "/", params = "username")
    public User getUserByUsername(@RequestParam String username){
        if(username == null || username.isEmpty())
            return null;
        return service.getUserByUsername(username);
    }

    @GetMapping(value = "/", params = "email")
    public User getUserByEmail(@RequestParam String email){
        if(email == null || email.isEmpty())
            return null;
        return service.getUserByEmail(email);
    }

    @GetMapping("/")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping("/")
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
