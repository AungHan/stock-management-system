package com.aunghan.stockmanagementsystem.repository;

import com.aunghan.stockmanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByUsername(String username);
    Employee findByEmail(String email);
}
