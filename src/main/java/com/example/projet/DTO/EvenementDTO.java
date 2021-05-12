package com.example.projet.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EvenementDTO {
    private Integer codeEvenement;
    private Double montant;
    private String description;
    private Date dateEvenement;

    public EvenementDTO(Integer codeEvenement,  String description,Double montant, Date dateEvenement) {
        this.codeEvenement = codeEvenement;
        this.montant = montant;
        this.description = description;
        this.dateEvenement = dateEvenement;
    }
}
