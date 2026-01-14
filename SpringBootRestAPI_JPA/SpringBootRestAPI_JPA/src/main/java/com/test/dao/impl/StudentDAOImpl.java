package com.test.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.StudentDAO;
import com.test.entity.Student;
import com.test.repository.StudentRepository;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private StudentRepository repo;

	@Override
	public Student createStudent(Student st) {

		return repo.save(st);
	}

	@Override
	public Optional<Student> getStudentById(int id) {
		return repo.findById(id);
	}

	@Override
	public Student updateStudentById(Student st) {
		return repo.save(st);
	}

	@Override
	public List<Student> deleteStudentById(int id) {
		repo.deleteById(id);
		return repo.findAll();
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

}
