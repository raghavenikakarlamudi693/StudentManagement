package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_seq")
@SequenceGenerator(name="student_seq",sequenceName="STUDENT_SEQ",allocationSize=1)
	private Long id;
	private String name;
	private String gender;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="dept_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Department department;
	
		public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Student(String name, Department department, String gender) {
		super();
		this.name = name;
		this.department = department;
		this.gender = gender;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", department=" + department + ", gender=" + gender + "]";
	}
	

}
