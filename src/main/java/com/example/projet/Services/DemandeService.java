package com.example.projet.Services;

import com.example.projet.DTO.DemandeRequestDTO;
import com.example.projet.Models.Demande;
import com.example.projet.Models.User;
import com.example.projet.Repositories.DemandeRepository;
import com.example.projet.Repositories.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private EvenementRepository evenementRepository;


    public String saveDemande(DemandeRequestDTO request, Model model) {
        var evenement = evenementRepository.findById(request.getCodeEvenement());
        if(evenement.isEmpty())
            return "employee?error=true";

        var demande = new Demande(request);

        demande.setEvenement(evenement.get());
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        demande.setUser(user);
        user.getDemandes().add(demande);
        demandeRepository.save(demande);
        var canNotSendDemande = true;
        model.addAttribute("canNotSendDemande",canNotSendDemande);
        model.addAttribute("isAccepted",false);
        return "employee";
    }

    public String acceptDemande(String cin,Model model) {
        var demande = demandeRepository.findById(cin);
        if (demande.isEmpty()){
            return "redirect:/admin?error=true";
        }

        demandeRepository.acceptDemande(cin);

        model.addAttribute("isAccepted",true);
        return "redirect:/admin";
    }

    public String deleteDemande(String cin,Model model) {
        var demande = demandeRepository.findById(cin);
        if (demande.isEmpty()){
            return "redirect:/admin?error=true";
        }

        demandeRepository.delete(demande.get());

        model.addAttribute("isDeleted",true);
        return "redirect:/admin";
    }
}
