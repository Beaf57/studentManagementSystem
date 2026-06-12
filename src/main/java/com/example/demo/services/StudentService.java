package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentInsertDTO;
import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;
	
	public void saveStudent(Student obj) {
		repo.save(obj);
	}
	
	public List<Student> findAll() {
		return repo.findAll();
	}
	
	public Student findById(Long id) {
		Optional<Student> student = repo.findById(id);
		return student.orElseThrow(() -> new ObjectNotFoundException("The specified object was not found."));
	}
	
	public Student update(Student obj) {
		Student newStudent = findById(obj.getRegistration());
		UpdateDate(newStudent, obj);
		return repo.save(newStudent);
	}

	private Student UpdateDate(Student newStudent, Student obj) {
		newStudent.setEmail(obj.getEmail());
		newStudent.setName(obj.getName());
		newStudent.setNotas(obj.getNotas());
		newStudent.setAcademicStatus();
		return newStudent;
	}
	
	public void delete(long id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Student fromDTO(StudentInsertDTO objDTO) {
		return new Student(objDTO.getRegistration(), objDTO.getName(), objDTO.getEmail(), objDTO.getPassword());
	}
}
