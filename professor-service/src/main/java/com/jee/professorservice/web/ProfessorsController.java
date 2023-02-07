package com.jee.professorservice.web;

import com.jee.professorservice.entities.Professor;
import com.jee.professorservice.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorsController {
    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping("/professors")
    public Professor saveProfessor(@RequestBody Professor professor){
        return professorRepository.save(professor);
    }
    @DeleteMapping("/professors/{id}")
    public void deleteProfessor(@PathVariable Long id){
        professorRepository.deleteById(id);
    }
    @PutMapping("/professors/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor newProfessor){
        Professor professor = professorRepository.findById(id).get();
        if(newProfessor.getName() != null) professor.setName(newProfessor.getName());
        if(newProfessor.getCoursID() != null) professor.setCoursID(newProfessor.getCoursID());
        return professorRepository.save(professor);
    }
}
