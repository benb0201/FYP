package com.example.travelpal.repository;

import com.example.travelpal.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository
        extends JpaRepository<Client, Long> {

    Optional<Client> findClientByEmailAndPassword(String email, String password);

    @Query("SELECT c FROM Client c WHERE c.email = ?1")
    Optional<Client> findClientByEmail(String email);
}
