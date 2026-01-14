package com.test.model;

import java.util.ArrayList;
import java.util.List;

public class Employees {
private List<Employee> empList;
public List<Employee> getEmpList(){
	if(empList==null) {
		empList = new ArrayList<>();
	}
	return empList;
}
public void setEmplist(List<Employee> empList) {
	this.empList=empList;
}

}
