package com.aunghan.stockmanagementsystem.service.impl;

import com.aunghan.stockmanagementsystem.entity.User;
import com.aunghan.stockmanagementsystem.service.UserDetails;
import lombok.Data;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDetailsImpl implements UserDetails {
    private int id;
    private String username;
    private String password;
    private String email;

//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UserDetailsImpl(int id, String username, String email, String password,
//                           Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.authorities = authorities;
//    }

//    public static UserDetailsImpl build(User user) {
//        List<GrantedAuthority> authorities = user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
//                .collect(Collectors.toList());
//
//        return new UserDetailsImpl(
//                user.getId(),
//                user.getUsername(),
//                user.getEmail(),
//                user.getPassword(),
//                authorities);
//    }
}
