package com.jee.coursservice.web;

import com.jee.coursservice.entity.Cours;
import com.jee.coursservice.repositories.CoursRepository;
import com.jee.coursservice.services.ClassroomRestService;
import com.jee.coursservice.services.ProfessorRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursRestController {
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private ClassroomRestService classroomRestService;
    @Autowired
    private ProfessorRestService professorRestService;
    @GetMapping("/cours/{id}")
    public Cours getCoursById(@PathVariable Long id){
        Cours cours=coursRepository.findById(id).get();
        cours.setClassroom(classroomRestService.findClassroomById(cours.getClassroomId()));
        cours.setProfessor(professorRestService.findProfessorById(cours.getProfessorId()));
        return cours;
    }
    @GetMapping("/cours")
    public List<Cours> getAllCours(){
        List<Cours> coursList = coursRepository.findAll();
        return coursList;
    }
    @PostMapping("/cours")
    public void addCours(@RequestBody Cours cours){
        if (cours == null) throw new RuntimeException("Invalid Cours");
        else  {
            coursRepository.save(cours);
        }
    }
    @DeleteMapping("/cours/{id}")
    public void deleteCours(@PathVariable Long id){
        Cours cours = coursRepository.findById(id).get();
        coursRepository.delete(cours);
    }
}
