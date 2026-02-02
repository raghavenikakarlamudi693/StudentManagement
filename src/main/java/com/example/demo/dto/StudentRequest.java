package com.example.demo.dto;
import com.example.demo.model.Department;

public class StudentRequest {
	private String name;
	private Department department;
	private String gender;
	public StudentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentRequest(String name, String branch, String gender) {
		super();
		this.name = name;
		this.department = department;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
