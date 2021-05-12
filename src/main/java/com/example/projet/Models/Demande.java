package com.example.projet.Models;

import com.example.projet.DTO.DemandeRequestDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "demandes")
@Getter
@Setter
public class Demande implements Serializable {

    @Id
    private String  cinEmploye;
    private String  matricule;
    private String  nom;
    private String  prenom;
    private String  adresse;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  dateNaissance;
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
    private Boolean isAccepted;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne
    private Evenement evenement;


    public Demande(DemandeRequestDTO dto){
        this();
        this.cinEmploye = dto.getCinEmploye();
        this.matricule = dto.getMatricule();
        this.nom = dto.getNom();
        this.prenom = dto.getPrenom();
        this.adresse = dto.getAdresse();
        this.dateNaissance = dto.getDateNaissance();
        this.salaire = dto.getSalaire();
        this.situationSociale = dto.getSituationSociale();
        this.numTel = dto.getNumTel();
        this.nombreEnfants = dto.getNombreEnfants();
        this.nombreEnfantsEndicapes = dto.getNombreEnfantsEndicapes();
        this.nombreEnfantsETD = dto.getNombreEnfantsETD();
        this.nombreEnfantsEMP = dto.getNombreEnfantsEMP();
        this.etatLogement = dto.getEtatLogement();
        this.depenseLoyer = dto.getDepenseLoyer();
        this.administration = dto.getAdministration();
    }
    public Demande() {
        this.dateDemande = new Date();
        this.isAccepted = false;
    }
}
