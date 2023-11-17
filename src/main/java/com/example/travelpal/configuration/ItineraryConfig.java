package com.example.travelpal.configuration;

import com.example.travelpal.DestinationList;
import com.example.travelpal.repository.ItineraryRepository;
import com.example.travelpal.models.Client;
import com.example.travelpal.models.Itinerary;
import com.example.travelpal.repository.ClientRepository;
import com.example.travelpal.models.Destination;
import com.example.travelpal.repository.DestinationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.AUGUST;
import static java.time.Month.JULY;

@Configuration
public class ItineraryConfig extends DestinationConfig {
    @Bean
    CommandLineRunner commandLineRunner(ItineraryRepository itineraryRepository, ClientRepository clientRepository, DestinationRepository destinationRepository) {
        return args -> {
            // Create clients
            Client client1 = clientRepository.save(new Client("Alice", "alice@example.com", LocalDate.of(1990, JULY, 15)));
            Client client2 = clientRepository.save(new Client("Bob", "bob@example.com", LocalDate.of(1985, AUGUST, 25)));

            // Create destinations
            DestinationList destinationList = new DestinationList();
            destinationRepository.saveAll(destinationList.getDestinations());
//            Destination destination1 = destinationRepository.save(new Destination("Paris", "France", "Eiffel Tower, Louvre Museum"));
//            Destination destination2 = destinationRepository.save(new Destination("New York", "USA", "Statue of Liberty, Central Park"));

            // Create itineraries
            Itinerary itinerary1 = new Itinerary("Summer Vacation", "Exploring Europe", LocalDate.of(2023, JULY, 1), LocalDate.of(2023, JULY, 15),
                    List.of(destinationList.getParis(), destinationList.getLondon()), client1);

            Itinerary itinerary2 = new Itinerary("City Break", "Quick getaway", LocalDate.of(2023, AUGUST, 10), LocalDate.of(2023, AUGUST, 15),
                    List.of(destinationList.getAmsterdam()), client2);

            itineraryRepository.saveAll(List.of(itinerary1, itinerary2));
        };
    }
}