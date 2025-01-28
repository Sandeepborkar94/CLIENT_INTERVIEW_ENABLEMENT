package com.practice.HR_managmentSystem.service;

import java.util.List;

import com.practice.HR_managmentSystem.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	Employee editEmployee(Employee employee);

	Employee searchEmployee(int empId);

	List<Employee> viewAllEmployees();

	void removeEmployee(int empId);
}
