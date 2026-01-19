package com.test.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
 
import com.test.entity.Student;
import com.test.repository.RemoteStudentRepository;
 
@RestController
public class StudentController {
 
	@Autowired
	private RemoteStudentRepository repository;
	
	
	@GetMapping("/list")
	public List<Student> getAllStudents()
	{
		
		return repository.getAllStudents();
		
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
	
		return repository.getStudentById(id);
		
	}
}
 