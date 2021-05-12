package com.example.projet.Controllers;

import com.example.projet.DTO.DemandeRequestDTO;
import com.example.projet.Services.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/demande")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;

    @PostMapping(path = {"/",""}, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String saveDemande(DemandeRequestDTO demande, Model model) {
        return demandeService.saveDemande(demande, model);
    }

    @PostMapping("/accepter")
    public String acceptDemande(@RequestParam("cin") String cin,Model model) {
        return demandeService.acceptDemande(cin,model);
    }

    @PostMapping("/delete")
    public String deleteDemande(@RequestParam("cin") String cin,Model model) {
        return demandeService.deleteDemande(cin,model);
    }
}