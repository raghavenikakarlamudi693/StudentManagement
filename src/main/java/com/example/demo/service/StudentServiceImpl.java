package com.example.demo.service;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.repository.StudentRepository;
import com.example.demo.dto.StudentRequest;
import com.example.demo.dto.StudentResponse;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<StudentResponse> getAllStudents()
	{
		List<Student> studentsList = studentRepository.findAll();

	    List<StudentResponse> responseList = new ArrayList<>();

	    for (Student student : studentsList) {
	        responseList.add(mapToResponse(student));
	    }

	    return responseList;
	}
	
	@Override
	public StudentResponse getStudentById(Long id)
	{
		Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found with id:"+id));
	    return mapToResponse(student);
	}
	private StudentResponse mapToResponse(Student student)
	{
		StudentResponse response = new StudentResponse();
		response.setId(student.getId());
		response.setName(student.getName());
		response.setBranch(student.getBranch());
		response.setGender(student.getGender());
		return response;
		
	}
	

	@Override
	public StudentResponse saveStudent(StudentRequest request) {
		// TODO Auto-generated method stub
		Student student = new Student();
	    student.setName(request.getName());
	    student.setBranch(request.getBranch());
	    student.setGender(request.getGender());

	    // 🔑 IMPORTANT: use returned entity
	    Student savedStudent = studentRepository.save(student);

	    return mapToResponse(savedStudent);
	}
	
	@Override
	public StudentResponse updateStudent(Long id, StudentRequest request)
	{
		Student existingStudent = studentRepository.findById(id)
	            .orElseThrow(() -> new StudentNotFoundException(
	                    "Student not found with id: " + id));
	
		existingStudent.setName(request.getName());
		existingStudent.setBranch(request.getBranch());
		existingStudent.setGender(request.getGender());
	    
	    Student updatedStudent = studentRepository.save(existingStudent);
	    return mapToResponse(updatedStudent);

	}
	@Override 
	public void deleteStudent(Long id)
	{
		Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found with id:"+id));
		studentRepository.deleteById(id);
	}
	
	

}
