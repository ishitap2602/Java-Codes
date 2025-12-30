package com.test;

public class Employee {
int id;
String name;
String cmp;

public Employee() {
	System.out.println("Default Constructor");
}

public Employee(int id, String name) {
	this.id=id;
	this.name=name;
	System.out.println("Parameterised Constructor " +  id + " " + name);
}

public Employee(int id, String name, String cmp) {
	System.out.println("Overload Constructor");
}

public Employee(Employee obj) {
	System.out.println("Object parameterised Constructor");
}
	public static void main(Strings1[] args) {
		// TODO Auto-generated method stub
		Employee obj1 = new Employee();
		Employee obj2 = new Employee(1, "Ishita");
		Employee obj3 = new Employee(1, "Ishita", "IBM");
		Employee obj4 = new Employee(new Employee());
		Employee obj5 = new Employee(obj1);

		
		
		
	}

}
