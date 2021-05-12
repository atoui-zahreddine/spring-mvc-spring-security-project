package com.example.projet.Services;

import com.example.projet.DTO.LoginRequestDTO;
import com.example.projet.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    public RedirectView login(LoginRequestDTO request) {
        Authentication authentication;
        try{
            authentication=authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getLogin(),request.getPassword())
            );
        }
        catch (org.springframework.security.authentication.BadCredentialsException ex){
            return new RedirectView("login?error=true");
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var user =(User)authentication.getPrincipal();

        return user.getIsAdmin() ? new RedirectView("admin"):new RedirectView("employee");
    }
}

