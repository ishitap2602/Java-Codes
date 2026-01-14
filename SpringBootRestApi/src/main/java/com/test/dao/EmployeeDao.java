package com.test.dao;

import java.util.List;

import com.test.model.Employee;

public interface EmployeeDao {
public Employee addEmployee(Employee emp);
public Employee updateEmployee(Employee emp);
public List<Employee> deleteEmployee(int id);
public List<Employee> getAllEmployees();





}
