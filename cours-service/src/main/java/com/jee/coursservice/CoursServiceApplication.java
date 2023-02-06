package com.jee.coursservice;


import com.jee.coursservice.entity.Cours;
import com.jee.coursservice.models.Classroom;
import com.jee.coursservice.models.Professor;
import com.jee.coursservice.repositories.CoursRepository;
import com.jee.coursservice.services.ClassroomRestService;
import com.jee.coursservice.services.ProfessorRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;

@EnableFeignClients
@SpringBootApplication
public class CoursServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursServiceApplication.class, args);
    }
    //@Bean
    CommandLineRunner start(CoursRepository coursRepository,
                            ClassroomRestService classroomRestService,
                            ProfessorRestService professorRestService){
        return args -> {
            Collection<Classroom> classrooms=classroomRestService.allClassrooms().getContent();
            Long professorId = 1L;
            Professor professor =professorRestService.findProfessorById(professorId);
            Long classroomId = 1L;
            Classroom classroom =classroomRestService.findClassroomById(classroomId);
            if (professor == null && classroom == null) throw new RuntimeException("professor or classroom not found ");
            Cours cours= new Cours();
            cours.setName("JAVA");
            cours.setDuration(2);
            cours.setStarterDate(new Date());
            cours.setProfessorId(professorId);
            cours.setClassroomId(classroomId);
            Cours savedCours = coursRepository.save(cours);

        };
    }
}
