package com.example.projet.Controllers;

import com.example.projet.Models.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping("/")
    public RedirectView homePage(){
        var authentication =  SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken)
            return  new RedirectView("login");
        var user =(User) authentication.getPrincipal();
        return  user.getIsAdmin() ? new RedirectView("admin") : new RedirectView("employee") ;
    }
}
