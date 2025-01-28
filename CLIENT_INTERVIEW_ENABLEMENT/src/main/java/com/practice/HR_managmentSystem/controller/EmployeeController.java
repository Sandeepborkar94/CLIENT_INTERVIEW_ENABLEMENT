package com.practice.HR_managmentSystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.HR_managmentSystem.entity.Employee;
import com.practice.HR_managmentSystem.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/edit")
    public Employee editEmployee(@RequestBody Employee employee) {
        return employeeService.editEmployee(employee);
    }

    @GetMapping("/search/{id}")
    public Employee searchEmployee(@PathVariable int id) {
        return employeeService.searchEmployee(id);
    }

    @GetMapping("/view-all")
    public List<Employee> viewAllEmployees() {
        return employeeService.viewAllEmployees();
    }

    @DeleteMapping("/remove/{id}")
    public String removeEmployee(@PathVariable int id) {
        employeeService.removeEmployee(id);
        return "Employee with ID " + id + " has been removed.";
    }
}
