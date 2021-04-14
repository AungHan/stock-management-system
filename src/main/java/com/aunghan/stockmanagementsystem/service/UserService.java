package com.aunghan.stockmanagementsystem.service;

import com.aunghan.stockmanagementsystem.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User saveUser(User user);

    String deleteUser(int id);

    User updateUser(User user);

    User getUserById(int id);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    String setActiveStatus(int id, boolean isActive);
}
