package com.test.dao;

import java.util.List;
import java.util.Optional;

import com.test.entity.Student;

public interface StudentDAO {

	
	public Student createStudent(Student std);
	
	public Optional<Student> getStudentById(int id);
	
	public Student updateStudentById(Student std);
	
	public List<Student> deleteStudentById(int id);
	
	public List<Student> getAllStudents();
	
}
