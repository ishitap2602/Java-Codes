package com.test.repository;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
 
import com.test.entity.Student;
 
public class RemoteStudentRepository {
 
	public static final String STUDENT_URL="http://SPRINGBOOTSTUDENTMICROSERVICE";
	
	@Autowired
	protected RestTemplate restTemplate;
	
	public List<Student> getAllStudents()
	{
		List<Student> data=restTemplate.getForObject(STUDENT_URL+"/students", new ArrayList<Student>().getClass());
		
		Student[] arr=restTemplate.getForObject(STUDENT_URL+"/students", Student[].class);
		
		List<Student> listStd=Arrays.asList(arr);
				return data;
	}
	public Student getStudentById( int id) {
		
		Student obj=restTemplate.getForObject(STUDENT_URL+"/student/{id}", Student.class,id);
	
		return obj;
		
	}
}
 
 