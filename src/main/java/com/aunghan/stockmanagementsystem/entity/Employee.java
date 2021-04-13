package com.aunghan.stockmanagementsystem.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employee")
public class Employee {
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

    public Employee(){}

    public Employee(String username, String password, String email, int accessLevel) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.accessLevel = accessLevel;
    }

    public String toString(){
        return String.format("Employee=[id:%d, username:%s]", this.id, this.username);
    }
}
