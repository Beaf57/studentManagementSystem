package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.enums.AcademicStatus;
import com.example.demo.model.Student;

public class StudentAcademicStatusDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long registration;
	private String name;
	private AcademicStatus academicStatus;
	public StudentAcademicStatusDTO(Student obj) {
		super();
		this.registration = obj.getRegistration();
		this.name = obj.getName();
		this.academicStatus = obj.getAcademicStatus();
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
	public AcademicStatus getAcademicStatus() {
		return academicStatus;
	}
	public void setAcademicStatus(AcademicStatus academicStatus) {
		this.academicStatus = academicStatus;
	}

}
