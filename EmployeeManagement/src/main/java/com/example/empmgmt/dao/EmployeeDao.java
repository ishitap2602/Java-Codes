package com.example.empmgmt.dao;
import java.util.List;

import com.example.empmgmt.entity.*;
public interface EmployeeDao {
public Boolean addEmployee(Employee emp);
public Boolean updateEmployee(Employee emp);
public List<Employee> deleteEmployee(int id);
public List<Employee> getAllEmployees();
}
