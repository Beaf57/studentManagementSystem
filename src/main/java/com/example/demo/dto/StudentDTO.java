package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.Student;

public class StudentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long registration;
	private String name;
	
	public StudentDTO(Student obj) {
		super();
		this.registration = obj.getRegistration();
		this.name = obj.getName();
	}

	public Long getRegistration() {
		return registration;
	}

	public void setRegistration(Long registration) {
		this.registration = registration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
