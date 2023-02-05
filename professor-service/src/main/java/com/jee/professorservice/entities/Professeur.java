package com.jee.professorservice.entities;

import com.jee.professorservice.enums.TauxAbsense;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Professeur {
    @Id
    private String id;
    private String nom;
    private Double numClass;
    private String nomClass;
    private Date TempsDecours;
    private String matiere;
    @Enumerated(EnumType.STRING)
    private TauxAbsense tauxAbsense;

}
