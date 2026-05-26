package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.demo.enums.AcademicStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="td_produto")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long registration;
	
	@NotBlank
	private String name;
	
	
	private String email;
	private List<Double> notas = new ArrayList<>();
	private AcademicStatus academicStatus;
	
	public Student(Long registration, String name, String email) {
		super();
		this.registration = registration;
		this.name = name;
		this.email = email;
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

	public void setAcademicStatus() {
		if(getMedia() >= 6) {
			this.academicStatus = AcademicStatus.APROVADO;
		} else {
			this.academicStatus = AcademicStatus.REPROVADO;
		}
	}
	
	public Double getMedia() {
		Optional<Double> media = notas.stream().reduce((a, b) -> a + b);
		if(media.isPresent()) {
			return media.get()/notas.size();
		}
			throw new IllegalArgumentException("The list of notes cannot be empty.");
	}

	@Override
	public int hashCode() {
		return Objects.hash(registration);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(registration, other.registration);
	}
	
	
	
}
