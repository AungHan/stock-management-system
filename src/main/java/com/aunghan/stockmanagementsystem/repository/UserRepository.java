package com.aunghan.stockmanagementsystem.repository;

import com.aunghan.stockmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByToken(String token);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
