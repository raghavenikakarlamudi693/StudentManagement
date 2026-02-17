package com.example.demo.service;
import java.util.ArrayList;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.transaction.Transactional;

import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.dto.StudentRequest;
import com.example.demo.dto.StudentResponse;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
		
	@PostConstruct 
	public void init()
	{
		System.err.println("Bean created "+ this.getClass().getSimpleName());
	}
	
	@PreDestroy
	public void destroy()
	{
		System.err.println("Servic Bean Destroyed");
	}
	
	
	private final StudentRepository studentRepository;
	private final DepartmentRepository departmentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository,DepartmentRepository departmentRepository )
	{
		this.studentRepository=studentRepository;
		this.departmentRepository = departmentRepository;
	}
	
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
		response.setDeptId(student.getDepartment().getDeptId());
		response.setDeptName(student.getDepartment().getDeptName());
		response.setGender(student.getGender());
		return response;
		
	}
	

	@Override
	@Transactional
	public StudentResponse saveStudent(StudentRequest request) {
		// TODO Auto-generated method stub
		Student student = new Student();
	    student.setName(request.getName());
	    Department dept = departmentRepository.findById(request.getDeptId()).orElseThrow(() -> new RuntimeException("Department not found"));
	    student.setDepartment(dept);
	    student.setGender(request.getGender());

	    // IMPORTANT: use returned entity
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
		Department deptFromDB = departmentRepository.findById(request.getDeptId()).orElseThrow(() -> new RuntimeException("Departement not found"));
		existingStudent.setDepartment(deptFromDB);
		existingStudent.setGender(request.getGender());
	    
	    Student updatedStudent = studentRepository.save(existingStudent);
	    return mapToResponse(updatedStudent);

	}
	@Override 
	@Transactional
	public void deleteStudent(Long id)
	{
		studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found with id:"+id));
		studentRepository.deleteById(id);
	}
	
	

}
