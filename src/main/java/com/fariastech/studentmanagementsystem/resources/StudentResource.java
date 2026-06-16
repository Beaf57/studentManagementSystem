package com.fariastech.studentmanagementsystem.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fariastech.studentmanagementsystem.dto.StudentDTO;
import com.fariastech.studentmanagementsystem.dto.StudentInsertDTO;
import com.fariastech.studentmanagementsystem.entities.Student;
import com.fariastech.studentmanagementsystem.services.StudentService;

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
	
	@GetMapping
	public ResponseEntity<List<StudentDTO>> findAll(){
		List<Student> list = service.findAll();
		List<StudentDTO> listDTO = list.stream()
				.map(StudentDTO::new)
				.toList();
		
		return  ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> findById(@PathVariable Long id){
		Student student = service.findById(id);
		StudentDTO studentDTO = new StudentDTO(student);
		
		return ResponseEntity.ok().body(studentDTO);	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentDTO> update(@PathVariable Long id, @RequestBody StudentDTO dto){
		Student student = new Student(dto.getRegistration(), dto.getName(), dto.getEmail());
		Student updateStudent = service.update(student, id);
		return ResponseEntity.ok().body(new StudentDTO(updateStudent));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
