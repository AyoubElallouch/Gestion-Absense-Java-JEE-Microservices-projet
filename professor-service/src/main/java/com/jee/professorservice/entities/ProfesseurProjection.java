package com.jee.professorservice.entities;

import com.jee.professorservice.enums.TauxAbsense;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Professeur.class, name = "p1")
public interface ProfesseurProjection {
    public String getId();
    public TauxAbsense getTauxAbsence();
}
