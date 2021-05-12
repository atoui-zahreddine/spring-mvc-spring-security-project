package com.example.projet.Repositories;

import com.example.projet.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String > {
    @Query("select u from User u where u.login=:login")
    Optional<User> findById(@Param("login") String login);
}
