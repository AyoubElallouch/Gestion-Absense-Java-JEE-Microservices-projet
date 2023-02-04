package com.jee.coursservice;


import com.jee.coursservice.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CoursServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CoursServiceApplication.class, args);
    }
    @Autowired
    CoursRepository coursRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i<4; i++){

        }


    }
}
