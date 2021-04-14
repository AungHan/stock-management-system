package com.aunghan.stockmanagementsystem.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="access_level")
    private int accessLevel;

    @Column(name="is_active")
    private boolean isActive;

    public User(){}

    public User(String username, String password, String email, int accessLevel) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.accessLevel = accessLevel;
    }

    public String toString(){
        return String.format("User=[id:%d, username:%s]", this.id, this.username);
    }
}
