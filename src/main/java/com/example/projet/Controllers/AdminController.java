package com.example.projet.Controllers;

import com.example.projet.Repositories.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private DemandeRepository demandeRepository;
    @GetMapping("")
    public String adminPage( Model model){
        model.addAttribute("demandes",demandeRepository.getAll());
        return "admin";
    }
}
