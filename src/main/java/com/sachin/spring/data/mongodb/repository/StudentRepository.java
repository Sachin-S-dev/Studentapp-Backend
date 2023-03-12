package com.sachin.spring.data.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sachin.spring.data.mongodb.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

	 List<Student> findAll();
}
