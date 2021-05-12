package com.example.projet.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "evenements")
public class Evenement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Integer codeEvenement;
    private Double montant;
    private String description;
    private Date dateEvenement;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "evenement")
    private List<Demande> demandes = new ArrayList<>();

    public Evenement(String description,Double montant, Date dateEvenement) {
        this.description=description;
        this.montant = montant;
        this.dateEvenement = dateEvenement;
    }

    public Evenement() {

    }
}
