package com.example.demo.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dto.StudentInsertDTO;
import com.example.demo.model.Student;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentResource {

	@Autowired
	private StudentService service;
	
	@PostMapping
	public ResponseEntity<Void> saveStudent(@RequestBody StudentInsertDTO studentInsertDTO){
		Student student = service.fromDTO(studentInsertDTO);
		service.saveStudent(student);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(student.getRegistration()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
