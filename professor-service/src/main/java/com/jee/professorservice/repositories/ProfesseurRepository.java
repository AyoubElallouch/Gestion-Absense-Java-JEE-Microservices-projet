package com.jee.professorservice.repositories;

import com.jee.professorservice.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProfesseurRepository  extends JpaRepository<Professeur,String> {
    // List<Professeur> findByNom(String nom);
}
