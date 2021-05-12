package com.example.projet.Startup;

import com.example.projet.Models.Evenement;
import com.example.projet.Models.User;
import com.example.projet.Repositories.DemandeRepository;
import com.example.projet.Repositories.EvenementRepository;
import com.example.projet.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class AppStartupRunner implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if(userRepository.findAll().isEmpty()) {

            var admin = new User();
            admin.setLogin("admin@admin.com");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setIsAdmin(true);
            userRepository.save(admin);

            var employee = new User();
            employee.setLogin("employer@employer.com");
            employee.setPassword(passwordEncoder.encode("employer"));
            employee.setIsAdmin(false);
            userRepository.save(employee);

            var evenement1= new Evenement("aid el Fetr",300.0,new SimpleDateFormat("dd-MM-yyyy").parse("12-06-2021"));
            var evenement2= new Evenement("aid el Idhha",300.0,new SimpleDateFormat("dd-MM-yyyy").parse("12-08-2021"));
            var evenement3= new Evenement("Rentré scolaire",400.0,new SimpleDateFormat("dd-MM-yyyy").parse("12-09-2021"));

            evenementRepository.saveAll(List.of(evenement1,evenement3,evenement2));
        }
    }
}
