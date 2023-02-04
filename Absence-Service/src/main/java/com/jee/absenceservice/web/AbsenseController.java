package com.jee.absenceservice.web;

import com.jee.absenceservice.entities.Absense;
import com.jee.absenceservice.repositories.AbsenseRepository;
import com.jee.absenceservice.services.CoursRestService;
import com.jee.absenceservice.services.ProfessorRestService;
import com.jee.absenceservice.services.StudentRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AbsenseController {
    @Autowired
    private AbsenseRepository absenseRepository;
    private StudentRestService studentRestService;
    private ProfessorRestService professorRestService;
    private CoursRestService coursRestService;

    @GetMapping("/absense/{id}")
    public Absense getAbsenseById(@PathVariable Long id){
        Absense absense = absenseRepository.findById(id).get();
        absense.setClassroom(studentRestService.findClassroomById(absense.getClassroomId()));
        absense.setStudent(studentRestService.findStudentById(absense.getStudentId()));
        absense.setCours(coursRestService.findCoursById(absense.getCoursId()));
        absense.setProfessor(professorRestService.findProfessorById(absense.getProfessorId()));
        return absense;
    }
    @GetMapping("/absenses")
    public List<Absense> getAllAbsenses(){
        List<Absense> absenseList = absenseRepository.findAll();
        absenseList.forEach(absense -> {
            absense.setClassroom(studentRestService.findClassroomById(absense.getClassroomId()));
            absense.setStudent(studentRestService.findStudentById(absense.getStudentId()));
            absense.setCours(coursRestService.findCoursById(absense.getCoursId()));
            absense.setProfessor(professorRestService.findProfessorById(absense.getProfessorId()));
        });
        return absenseList;
    }
    @DeleteMapping("/absenses/{id}")
    public void deleteabsense(@PathVariable Long id) {
        Absense absense = absenseRepository.findById(id).get();
        if (absense == null) throw new RuntimeException("Absense Not Found");
        else {
            absenseRepository.delete(absense);
        }
    }
}
