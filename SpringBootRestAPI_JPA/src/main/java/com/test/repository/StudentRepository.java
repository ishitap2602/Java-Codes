package com.test.repository;
 
import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.Student;
 
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("select s from Student s where s.name = ?1 name")
	public Optional<Student> getStudentByName(String name);
	
	
	@Query("select s from Student s where s.name = ?1 name")
	public List<Student> getStudentByDepartment(String department);
	
	
}