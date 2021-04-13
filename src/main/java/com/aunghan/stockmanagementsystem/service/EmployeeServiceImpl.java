package com.aunghan.stockmanagementsystem.service;

import com.aunghan.stockmanagementsystem.entity.Employee;
import com.aunghan.stockmanagementsystem.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getEmployees(){
        return this.repository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return this.repository.save(employee);
    }

    public String deleteEmployee(int id){
        this.repository.deleteById(id);
        return "deleted employee, id=" + id;
    }

    public Employee updateEmployee(Employee employee){
        log.info("update employee id="+employee.getId());

        Employee current = getEmployeeById(employee.getId());
        if(current == null) return null;

        current.setUsername(employee.getUsername());
        current.setPassword(employee.getPassword());
        current.setEmail(employee.getEmail());
        current.setAccessLevel(employee.getAccessLevel());

        return saveEmployee(employee);
    }

    public Employee getEmployeeById(int id){
        return this.repository.findById(id).orElse(null);
    }

    public Employee getEmployeeByUsername(String username){
        return this.repository.findByUsername(username);
    }

    public Employee getEmployeeByEmail(String email){
        return this.repository.findByEmail(email);
    }
}
