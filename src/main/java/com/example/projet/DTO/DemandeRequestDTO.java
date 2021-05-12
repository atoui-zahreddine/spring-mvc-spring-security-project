package com.example.projet.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter

public class DemandeRequestDTO {
    private String  cinEmploye;
    private String  matricule;
    private String  nom;
    private String  prenom;
    private String  adresse;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private Double  salaire;
    private String  situationSociale;
    private String  numTel;
    private Integer nombreEnfants;
    private Integer nombreEnfantsEndicapes;
    private Integer nombreEnfantsETD;
    private Integer nombreEnfantsEMP;
    private String etatLogement;
    private Double depenseLoyer;
    private String administration;
    private Date dateDemande;
    private Integer codeEvenement;
}
