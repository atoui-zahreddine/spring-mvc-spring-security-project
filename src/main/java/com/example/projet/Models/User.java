package com.example.projet.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails , Serializable {

    @Id
    private String login ;
    private String password;
    private Boolean isAdmin;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Demande> demandes=new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return isAdmin ? List.of((GrantedAuthority) () -> "ROLE_ADMIN"):List.of((GrantedAuthority) () -> "ROLE_EMPLOYEE");
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
