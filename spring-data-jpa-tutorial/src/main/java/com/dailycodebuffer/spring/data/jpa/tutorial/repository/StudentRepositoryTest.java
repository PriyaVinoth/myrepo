package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		
		Student student= Student.builder()
				.emailId("priya@gmail.com")
				.firstName("priya")
				.lastName("dharshini")
				//.guardianName("sai")
				//.guardianEmail("sai@shirdi.com")
				//.guardianMobile("9999999999")
				.build();
		studentRepository.save(student);
		
	}
	
	@Test
	public void saveStudentWithGuardian() {
		
		Guardian guardian = Guardian.builder()
									.email("sai@shirdi.com")
									.name("sai")
									.mobile("9999999999")
									.build();
		 
		Student student= Student.builder()
				.emailId("aaa@gmail.com")
				.firstName("aaa")
				.lastName("bbb")
				.guardian(guardian)
				.build();
		studentRepository.save(student);
		
	}
	@Test
	public void printAllStudent()
	{
		List<Student> studentList = studentRepository.findAll();
		
		System.out.println("Student List >>>>>"+studentList);
	}
	
	@Test
	public void printStudentByFirstName()
	{
		List<Student> studentList = studentRepository.findByFirstName("aaa");
		
		System.out.println("Student List >>>>>"+studentList);
	}
}
