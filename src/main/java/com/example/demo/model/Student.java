package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name="students")
public class Student {
	
	@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_seq")
@SequenceGenerator(name="student_seq",sequenceName="STUDENT_SEQ",allocationSize=1)
	private Long id;
	private String name;
	private String branch;
	private String gender;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Student(String name, String branch, String gender) {
		super();
		this.name = name;
		this.branch = branch;
		this.gender = gender;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", branch=" + branch + ", gender=" + gender + "]";
	}
	

}
