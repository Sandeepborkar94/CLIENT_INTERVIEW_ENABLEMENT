package com.practice.HR_managmentSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "emp_name", nullable = false)
    private String empName;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "base_Location", nullable = false)
    private String baseLocation;

    // Constructors
    public Employee() {}

    public Employee(String empName, String department, String baseLocation) {
        this.empName = empName;
        this.department = department;
        this.baseLocation = baseLocation;
    }

    // Getters and Setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }
}
