package com.jee.coursservice.services;

import com.jee.coursservice.models.Classroom;
import com.jee.coursservice.models.Professor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "PROFESSORS-SERVICE")
public interface ProfessorRestService {
    @GetMapping(path = "/professors/{id}")
    Professor findProfessorById(@PathVariable Long id);
}
