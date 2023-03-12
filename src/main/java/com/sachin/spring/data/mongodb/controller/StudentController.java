package com.sachin.spring.data.mongodb.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.spring.data.mongodb.model.Student;
import com.sachin.spring.data.mongodb.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:8081") // Allow requests from the React application
@RequestMapping("/api")
@RestController

public class StudentController {
  
  @Autowired
  StudentRepository studentRepository;

  @PostMapping("/students/add")  //ResponseEntity represents the whole HTTP response
  public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
    // Validation errors will be automatically caught by Spring
        student.setName(student.getName());
	student.setDob(student.getDob());
	student.setClassval(student.getClassval());
	student.setDivision(student.getDivision());
	student.setGender(student.getGender());
	student.setAdmissionNumber(student.getAdmissionNumber()); // Get admission number
        return ResponseEntity.ok(this.studentRepository.save(student));
	
  }
 
  

  
  @GetMapping("/students/getAll")
   public ResponseEntity<List<Student>> getAllStudents() {
      return ResponseEntity.ok(this.studentRepository.findAll());
  }   

       
  
}

	
	
	
   
	
		





