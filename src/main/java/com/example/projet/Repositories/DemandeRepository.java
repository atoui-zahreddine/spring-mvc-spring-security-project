package com.example.projet.Repositories;

import com.example.projet.DTO.DemandeDTO;
import com.example.projet.Models.Demande;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface DemandeRepository extends JpaRepository<Demande,String> {

    @Query(nativeQuery = true,
            value = "select * " +
                    "from demandes d " +
                    "where d.user_login=:login " +
                    "and " +
                    "d.date_demande between (DATE_FORMAT(NOW() ,'%Y')) and (NOW()) ")
    Optional<Demande> getUserDemandeByYear(@Param("login") String id);

    @Query("select new com.example.projet.DTO.DemandeDTO(d.cinEmploye,d.nom,d.prenom,d.evenement,d.dateDemande) from demandes d where d.isAccepted=false")
    List<DemandeDTO> getAll();

    @Query("update demandes set isAccepted=true where cinEmploye=:cin")
    @Transactional
    @Modifying
    void acceptDemande(@Param("cin") String cin);
}
