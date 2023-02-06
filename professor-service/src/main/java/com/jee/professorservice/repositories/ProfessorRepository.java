package com.jee.professorservice.repositories;

import com.jee.professorservice.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfessorRepository extends JpaRepository<Professor,String> {
    // List<Professeur> findByNom(String nom);
}
