package com.jee.professorservice;

import com.jee.professorservice.entities.Professor;
import com.jee.professorservice.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProfessorServiceApplication implements CommandLineRunner {
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(ProfessorServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Professor.class);
        for(int i=1; i<6; i++){
            Professor professor = new Professor();
            professor.setNom("Prof_"+i);
            professor.setCoursID((long)i);
            professorRepository.save(professor);
        }

    }
}
