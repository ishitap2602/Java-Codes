package com.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.StudentDAO;
import com.test.entity.Student;
import com.test.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO dao;

	@Override
	public Student createStudent(Student std) {

		return dao.createStudent(std);
	}

public Optional<Student> getStudentById(int id) {
		
		return dao.getStudentById(id);
	}
 
	@Override
	public Student updateStudentById(Student st) {
		
		return dao.updateStudentById(st);
	}
 
	@Override
	public List<Student> deleteStudentById(int id) {
		return dao.deleteStudentById(id);
	}
 
	@Override
	public List<Student> getAllStudents() {
		return dao.getAllStudents();
	}

}
