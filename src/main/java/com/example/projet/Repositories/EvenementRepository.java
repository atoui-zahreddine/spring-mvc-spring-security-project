package com.example.projet.Repositories;

import com.example.projet.DTO.EvenementDTO;
import com.example.projet.Models.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement,Integer> {
    @Query("select new com.example.projet.DTO.EvenementDTO(e.codeEvenement,e.description,e.montant,e.dateEvenement) from evenements e")
    List<EvenementDTO> getAll();
}
