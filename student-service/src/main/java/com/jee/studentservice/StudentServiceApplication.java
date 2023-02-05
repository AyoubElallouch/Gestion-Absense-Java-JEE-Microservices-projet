package com.jee.studentservice;


import lombok.AllArgsConstructor;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication   @AllArgsConstructor

public class StudentServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}


}


