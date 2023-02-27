package com.sachin.spring.data.mongodb.model;

import org.springframework.data.annotation.Id;

import java.util.Random;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student{
@Id
private String id;

private String name;
private String dob;
private String classval;
private String division;
private String gender;
private String admissionNumber;




public Student(String name, String dob,String classval, String division, String gender, String admissionNumber) {
  this.name = name;
  this.dob = dob;
  this.classval = classval;
  this.division = division;
  this.gender = gender;
  this.admissionNumber = admissionNumber;
 
}

  public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getClassval() {
		return classval;
	}

	public void setClassval(String classval) {
		this.classval = classval;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAdmissionNumber() {
		return admissionNumber;
	}
     
	//to generate the admission number
	public void generateAdmissionNumber() {
	    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String numbers = "0123456789";
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < 3; i++) {
	      sb.append(letters.charAt(random.nextInt(letters.length())));
	    }
	    for (int i = 0; i < 3; i++) {
	      sb.append(numbers.charAt(random.nextInt(numbers.length())));
	    }
	    this.admissionNumber = "R-" + sb.toString();
	  }

	// validate the  data in back-end spring boot 
	@NotBlank(message = "Name is required")
	  @Size(max = 50, message = "Name must not exceed 50 characters")
	  @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters and spaces")
	  private String Name;

	  @NotBlank(message = "Date of birth is required")
	  private String Dob;

	  @NotBlank(message = "Class is required")
	  private String Classval;

	  @NotBlank(message = "Division is required")
	  private String Division;

	  @NotBlank(message = "Gender is required")
	  private String Gender;

	 
}
  
   

 
