package com.jee.studentservice.web;

import com.jee.studentservice.entities.Classroom;
import com.jee.studentservice.entities.Student;
import com.jee.studentservice.repositories.ClassroomRepository;
import com.jee.studentservice.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassroomRepository classroomRepository;

    @GetMapping("/students")
    public List<Student> students(){
        return studentRepository.findAll();
    }
    @GetMapping("/students/{id}")
    public Student studentById(@PathVariable Long id){
        return studentRepository.findById(id).get();
    }
    @GetMapping("/classrooms")
    public List<Classroom> classrooms(){
        return classroomRepository.findAll();
    }
    @GetMapping("/classrooms/{id}")
    public Classroom classroomById(@PathVariable Long id){
        return classroomRepository.findById(id).get();
    }
    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
    @PostMapping("/classrooms")
    public Classroom saveClassrooms(@RequestBody Classroom classroom){
        return classroomRepository.save(classroom);
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
    }
    @DeleteMapping("/classrooms/{id}")
    public void deleteClassrooms(@PathVariable Long id){
        classroomRepository.deleteById(id);
    }
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student newstudent){
        Student student = studentRepository.findById(id).get();

        if(newstudent.getFullName() != null) student.setFullName(newstudent.getFullName());
        if(newstudent.getAddress() != null) student.setAddress(newstudent.getAddress());
        if(newstudent.getGender() != null) student.setGender(newstudent.getGender());
        if(newstudent.getCIN() != null) student.setCIN(newstudent.getCIN());
        if(newstudent.getBirthDate() != null) student.setBirthDate(newstudent.getBirthDate());
        if(newstudent.getClassroom() != null) student.setClassroom(newstudent.getClassroom());

        return studentRepository.save(student);
    }
    @PutMapping("/classrooms/{id}")
    public Classroom updateClassroom(@PathVariable Long id, @RequestBody Classroom newclassroom){
        Classroom classroom = classroomRepository.findById(id).get();

        if(newclassroom.getName() != null) classroom.setName(newclassroom.getName());
        return classroomRepository.save(classroom);
    }
}
