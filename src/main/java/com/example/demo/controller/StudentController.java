package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentRequest;
import com.example.demo.dto.StudentResponse;
import com.example.demo.model.Student;

import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    

	@Autowired
	private StudentService studentService;

  
	
	@GetMapping
	public List<StudentResponse> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public StudentResponse getById( @PathVariable Long id)
	{
		return studentService.getStudentById(id);
	}
	
	@PostMapping
	public StudentResponse saveStudents(@RequestBody StudentRequest request)
	{

		return studentService.saveStudent(request);
	}
	@PutMapping("/{id}")
	public StudentResponse updateStudentById(@PathVariable Long id, @RequestBody StudentRequest request)
	{
		return studentService.updateStudent(id,request);
	}
	@DeleteMapping("/{id}")
	public String deleteStudentById(@PathVariable Long id)
	{
		studentService.deleteStudent(id);
		return "Student deleted successfully with id:"+id;
	}
	
	@GetMapping("/public")
    public String publicApi() {
        return "Public API - No Authentication Required";
    }

}
