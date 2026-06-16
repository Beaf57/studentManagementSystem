package com.fariastech.studentmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fariastech.studentmanagementsystem.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
