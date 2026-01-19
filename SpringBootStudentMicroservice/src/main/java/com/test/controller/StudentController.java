package com.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Student;

@RestController
public class StudentController {
	protected Logger log = Logger.getLogger(StudentController.class.getName());
	
	public static List<Student> data = new ArrayList<>();
	static {
		data.add(new Student(1, "Ishita", "MU"));
		data.add(new Student(2, "Vidhan", "PU"));
		data.add(new Student(3, "Jay", "BU"));
		data.add(new Student(4, "Soham", "GU"));
		data.add(new Student(5, "Tavmeet", "MU"));

	}
	
	@GetMapping("/student")
	public List<Student> listAllStudents(){
		log.info("Student data fetched");
		return data;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		log.info("STudent data by id");
		Student obj = null;
	
		for (int i=0; i<data.size(); i++) {
			Student std = data.get(i);
			if(std.getId() == id) {
				obj = data.get(i);
			}
		}
		return obj;
	}
	
}
