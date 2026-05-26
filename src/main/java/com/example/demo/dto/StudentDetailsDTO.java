package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.demo.enums.AcademicStatus;
import com.example.demo.model.Student;

public class StudentDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long registration;
	private String name;
	private String email;
	private List<Double> notas = new ArrayList<>();
	private AcademicStatus academicStatus;
	public StudentDetailsDTO(Student obj) {
		super();
		this.registration = obj.getRegistration();
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.academicStatus = obj.getAcademicStatus();
		this.notas = obj.getNotas();
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
	public List<Double> getNotas() {
		return notas;
	}
	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
	public AcademicStatus getAcademicStatus() {
		return academicStatus;
	}
	public void setAcademicStatus(AcademicStatus academicStatus) {
		this.academicStatus = academicStatus;
	}
	
}
