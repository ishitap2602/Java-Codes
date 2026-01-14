package com.test.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Student;
import com.test.service.StudentService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/student/v1/api")
@Tag(name = "Student Api", description = "Student Crud operations with JPA")
public class StudentController {

	@Autowired
	private StudentService service;
	
	
	Logger logger=LoggerFactory.getLogger(StudentController.class);

	@GetMapping("/log")
	@Operation(description="Logging Details",summary="slf4j")
public String log()
{
	logger.trace("Log level:TRACE");
	logger.info("Log level:INFO");
	logger.debug("Log level:Debug");
	logger.error("Log level:ERROR");
	logger.warn("Log level:WARN");
	
	return "check the output logs";
	
}
	@PostMapping("/create")
	@Operation(method = "CreateStudentMethod", description = "add student data to DB")
	public ResponseEntity<Student> createStudent(@RequestBody Student std)

	{
		Student obj = service.createStudent(std);
		String str=String.valueOf(obj.getId());
logger.info(str);		
logger.info(obj.getName());
logger.info(obj.getDepartment());
logger.info(obj.getCollege());
		if (std == null) {
			return new ResponseEntity<>(obj, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
		}

	}

	@GetMapping("/{id}")
	@Operation(method = "getStudentByID", description = "get student data from DB")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable int id)

	{

		Optional<Student> obj = service.getStudentById(id);

		if (id <= 0) {
			return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}

	}

	@PutMapping("/{id}")
	@Operation(method = "updateStudentByID", description = "update student data to DB by id")
	public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody Student std)

	{

		std.setId(id);

		Student obj = service.updateStudentById(std);

		if (id <= 0) {
			return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}

	}

	@DeleteMapping("/deleteById/{id}")
	@Operation(description = " DELETE STUDENT")
	@Tag(name = "HTTP DELETE", description = "DELETE STUDENT RECORD BY ID")
	public ResponseEntity<List<Student>> deleteStudentById(@PathVariable int id) {
		List<Student> obj = service.deleteStudentById(id);
		if (id <= 0) {
			return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(obj, HttpStatus.ACCEPTED);
		}

	}

	@GetMapping("/get")
	@Operation(description = " GET STUDENT")
	@Tag(name = "HTTP GET", description = "GET ALL STUDENT RECORDS")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> obj = service.getAllStudents();
		if (obj.size() <= 0) {
			return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}

	}

}
