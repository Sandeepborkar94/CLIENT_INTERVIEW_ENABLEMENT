package com.practice.HR_managmentSystem.service.impl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.HR_managmentSystem.entity.Employee;
import com.practice.HR_managmentSystem.exception.EmployeeNotFoundException;
import com.practice.HR_managmentSystem.repository.EmployeeRepository;
import com.practice.HR_managmentSystem.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Add Employee
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Edit Employee
    @Override
    public Employee editEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getEmpId());
        if (existingEmployee.isPresent()) {
            return employeeRepository.save(employee);
        } else {
            throw new EmployeeNotFoundException("Employee not found with ID: " + employee.getEmpId());
        }
    }

    // Search Employee
    @Override
    public Employee searchEmployee(int empId) {
        return employeeRepository.findById(empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + empId));
    }

    // View All Employees
    @Override
    public List<Employee> viewAllEmployees() {
        return employeeRepository.findAll();
    }

    // Remove Employee
    @Override
    public void removeEmployee(int empId) {
        if (employeeRepository.existsById(empId)) {
            employeeRepository.deleteById(empId);
        } else {
            throw new EmployeeNotFoundException("Employee not found with ID: " + empId);
        }
    }
}
