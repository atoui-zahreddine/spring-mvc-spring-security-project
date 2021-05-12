package com.example.projet.DTO;

import com.example.projet.Models.Evenement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DemandeDTO {

    private String cin;
    private String nom;
    private String prenom;
    private Evenement evenement;
    private Date dateDemande;

    public DemandeDTO(String cin, String nom, String prenom, Evenement evenement, Date dateDemande) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.evenement = evenement;
        this.dateDemande = dateDemande;
    }
}
