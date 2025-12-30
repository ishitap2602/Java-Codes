package com.test;

class Emp1{
	private int id;
	private String name;
	private String empType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
 
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", empType=" + empType + "]";
	}
}
	interface EmpBuilder{
		void employeeDetails();
		void employeeType();
	}
	class ImplBuilder implements EmpBuilder{
		private Emp1 emp=new Emp1();
		@Override
		public void employeeDetails() {
			emp.setId(101);
			emp.setName("Ishita");
		}
		@Override
		public void employeeType() {
			emp.setEmpType("Developer");
		}
	    public Employee employeeData() {
			return new Employee();
	    	
	    }
	}
	class BuilderTest
	{
		public void employeeInfo(EmpBuilder builder)
		{
			builder.employeeDetails();
			builder.employeeType();
		}
	}
 
public class BuilderDemo {
 
	public static void main(String[] args) {
		ImplBuilder empObj=new ImplBuilder();
		BuilderTest testBuilder=new BuilderTest();
		testBuilder.employeeInfo(empObj);
	    Employee emp=empObj.employeeData();
	   
	}
}
 
 
 