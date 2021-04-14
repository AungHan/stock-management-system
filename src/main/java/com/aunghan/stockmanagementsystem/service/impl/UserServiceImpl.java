package com.aunghan.stockmanagementsystem.service.impl;

import com.aunghan.stockmanagementsystem.entity.User;
import com.aunghan.stockmanagementsystem.repository.UserRepository;
import com.aunghan.stockmanagementsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getUsers(){
        return this.repository.findAll();
    }

    @Override
    public User saveUser(User user){
        return this.repository.save(user);
    }

    @Override
    public String deleteUser(int id){
        this.repository.deleteById(id);
        return "deleted employee, id=" + id;
    }

    @Override
    public User updateUser(User user){
        log.info("update employee id="+ user.getId());

        User current = getUserById(user.getId());
        if(current == null) return null;

        current.setUsername(user.getUsername());
        current.setPassword(user.getPassword());
        current.setEmail(user.getEmail());
        current.setAccessLevel(user.getAccessLevel());

        return saveUser(user);
    }

    @Override
    public User getUserById(int id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public User getUserByUsername(String username){
        return this.repository.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email){
        return this.repository.findByEmail(email);
    }

    @Override
    public String setActiveStatus(int id, boolean isActive){
        User current = getUserById(id);
        if(current == null) return "No user, id " + id;

        current.setActive(isActive);
        saveUser(current);
        return "User active status updated for id " + id;
    }
}
