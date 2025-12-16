package com.example.demo.service;

import java.util.*;

import com.example.demo.dto.StudentResponse;
import com.example.demo.dto.StudentRequest;
import com.example.demo.model.Student;

public interface StudentService {
	
	List<StudentResponse> getAllStudents();
	
	StudentResponse getStudentById(Long id);
	
	StudentResponse saveStudent(StudentRequest request);
	
	StudentResponse updateStudent(Long id,StudentRequest request );
	
	void deleteStudent(Long id);
	

}
