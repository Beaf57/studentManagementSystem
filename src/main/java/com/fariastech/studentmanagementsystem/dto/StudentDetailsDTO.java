package com.fariastech.studentmanagementsystem.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.fariastech.studentmanagementsystem.entities.Student;
import com.fariastech.studentmanagementsystem.enums.AcademicStatus;

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
