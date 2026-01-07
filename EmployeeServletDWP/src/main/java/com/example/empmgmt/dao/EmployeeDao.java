package com.example.empmgmt.dao;




import java.util.List;
import com.example.empmgmt.entity.Employee;

public interface EmployeeDao {
    boolean addEmployee(Employee emp);
    boolean updateEmployee(Employee emp);
    List<Employee> deleteEmployee(int id); // returns updated list
    List<Employee> getAllEmployees();
}
