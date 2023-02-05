package com.jee.professorservice.web;

import com.jee.professorservice.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class ProfesseurRestController {
    @Autowired
    private ProfesseurRepository professeurRepository;

}
