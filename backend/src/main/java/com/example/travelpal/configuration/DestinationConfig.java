package com.example.travelpal.configuration;

import com.example.travelpal.DestinationList;
import com.example.travelpal.repository.DestinationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DestinationConfig {

    @Bean
    CommandLineRunner commandLineRunner(DestinationRepository repository){
        return args -> {
            DestinationList destinationList = new DestinationList();
            repository.saveAll(destinationList.getDestinations());
        };
    }
}
