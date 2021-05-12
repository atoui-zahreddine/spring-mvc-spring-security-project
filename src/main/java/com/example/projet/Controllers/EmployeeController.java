package com.example.projet.Controllers;

import com.example.projet.Models.User;
import com.example.projet.Repositories.DemandeRepository;
import com.example.projet.Repositories.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EvenementRepository evenementRepository;
    @Autowired
    private DemandeRepository demandeRepository;

    @GetMapping("")
    public String employeePage(Model model) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var demande =demandeRepository.getUserDemandeByYear(user.getLogin());
        var canNotSendDemande = demande.isPresent();
        var isAccepted = demande.isPresent() && demande.get().getIsAccepted();
        model.addAttribute("evenements", evenementRepository.getAll());
        model.addAttribute("canNotSendDemande", canNotSendDemande);
        model.addAttribute("isAccepted",isAccepted);
        return "employee";
    }


}
