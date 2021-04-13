package com.aunghan.stockmanagementsystem.controller;

import com.aunghan.stockmanagementsystem.entity.Employee;
import com.aunghan.stockmanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){
        return service.getEmployeeById(id);
    }

//    @GetMapping("/employee")
//    public Employee getEmployeeByUsername(@RequestParam String username){
//        if(username == null || username.isEmpty())
//            return null;
//        return service.getEmployeeByUsername(username);
//    }

    @GetMapping("/employee")
    public Employee getEmployeeByEmail(@RequestParam String email){
        if(email == null || email.isEmpty())
            return null;
        return service.getEmployeeByEmail(email);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return service.getEmployees();
    }

    @PostMapping("/employee/new")
    public Employee saveEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @PutMapping("/employee/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        return service.deleteEmployee(id);
    }
}
