package com.example.travelpal.client;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository repository;

    //After each test, clear database for the next test
    @AfterEach
    void tearDown(){
        repository.deleteAll();
    }

    @Test
    void testFindClientByEmail() {
        // Given
        String email = "friend.org@gmail.com";
        Client client = new Client(
                "Friend",
                email,
                LocalDate.of(2000, Month.MARCH, 16)
        );

        repository.save(client); // Save the client to the database

        // When
        Optional<Client> foundClient = repository.findClientByEmail(email);

        // Then
        assertThat(foundClient).isPresent(); // Ensure the client is found
        assertThat(foundClient.get().getName()).isEqualTo("Friend"); // Check other properties as needed
    }

    @Test
    void testFindClientByEmailNotFound() {
        // When searching for a non-existent email
        String nonExistentEmail = "nonexistent@example.com";
        Optional<Client> foundClient = repository.findClientByEmail(nonExistentEmail);

        // Then
        assertThat(foundClient).isNotPresent(); // Ensure the result is empty
    }
}