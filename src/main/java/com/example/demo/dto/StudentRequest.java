package com.example.demo.dto;
import com.example.demo.model.Department;

public class StudentRequest {
	private String name;
	private Long deptId;
	private String deptName;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	private String gender;
	public StudentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentRequest(String name, String branch, String gender) {
		super();
		this.name = name;
		
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
