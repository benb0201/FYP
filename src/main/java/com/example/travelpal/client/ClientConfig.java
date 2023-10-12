package com.example.travelpal.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.OCTOBER;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository){
        return args -> {
            Client angel = new Client(
                    "Angel",
                    "angel.a@tmail.com",
                    LocalDate.of(2003, OCTOBER, 2)
            );

            Client ben = new Client(
                    "Ben",
                    "ben.b@tmail.com",
                    LocalDate.of(2002, JANUARY, 15)
            );

            repository.saveAll(
                    List.of(angel ,ben)
            );
        };
    }
}
