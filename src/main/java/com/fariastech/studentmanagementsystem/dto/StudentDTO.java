package com.fariastech.studentmanagementsystem.dto;

import java.io.Serializable;

import com.fariastech.studentmanagementsystem.entities.Student;

public class StudentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long registration;
	private String name;
	private String email;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
