package com.example.demo.dto;

public class StudentRequest {
	private String name;
	private String branch;
	private String gender;
	public StudentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentRequest(String name, String branch, String gender) {
		super();
		this.name = name;
		this.branch = branch;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
