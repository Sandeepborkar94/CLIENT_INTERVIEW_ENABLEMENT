package com.practice.HR_managmentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.HR_managmentSystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
