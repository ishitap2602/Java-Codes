package com.test.dao.impl;
 
import java.util.List;
 
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
 
import com.test.dao.EmployeeDao;
import com.test.model.Employee;
import com.test.model.Employees;
 
@Service
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
 
	private static Employees empData=new Employees();
	 static {
		 empData.getEmpList().add(new Employee(1,"Vidhan","Dell"));
		 empData.getEmpList().add(new Employee(2,"Ishita","Hp"));
		 empData.getEmpList().add(new Employee(3,"Jay","Google"));
		 empData.getEmpList().add(new Employee(4,"Madhav","Nvidia"));
		 empData.getEmpList().add(new Employee(5,"Aman","Qualcomm"));
		
		
		
	 }
	
	
	@Override
	public Employee addEmployee(Employee emp) {
 
		empData.getEmpList().add(emp);
		return emp;
	}
 
	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		for (int i = 0; i<empData.getEmpList().size(); i++) {
			Employee obj = empData.getEmpList().get(i);
			if(obj.getId().equals(emp.getId())) {
				empData.getEmpList().set(i, emp);
			}
		}
		return emp;
	}
 
	@Override
	public List<Employee> deleteEmployee(int id) {
		// TODO Auto-generated method stub
		for (int i = 0; i<empData.getEmpList().size(); i++) {
			Employee emp = empData.getEmpList().get(i);
			if(emp.getId().equals(id)) {
				empData.getEmpList().remove(i);
			}
		}
		return empData.getEmpList();
	}
 
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
				
		return empData.getEmpList();
	}
 
	
}
 
 