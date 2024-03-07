package com.example.travelpal.configuration;

import com.example.travelpal.models.Activity;
import com.example.travelpal.models.Client;
import com.example.travelpal.models.Itinerary;
import com.example.travelpal.repository.ActivityRepository;
import com.example.travelpal.repository.ClientRepository;
import com.example.travelpal.repository.ItineraryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.AUGUST;
import static java.time.Month.JULY;

@Configuration
public class ItineraryConfig {
    @Bean
    CommandLineRunner commandLineRunner(ItineraryRepository itineraryRepository, ClientRepository clientRepository, ActivityRepository activityRepository) {
        return args -> {
            // Create activities for the first itinerary
            Activity activity1 = new Activity("Visit Eiffel Tower", "Tour of the Eiffel Tower", "Paris, France", 50.0);
            Activity activity2 = new Activity("Boat Tour", "Boat tour on the Seine River", "Paris, France", 30.0);

            // Create activities for the second itinerary
            Activity activity3 = new Activity("City Tour", "Tour of Amsterdam", "Amsterdam", 40.0);
            Activity activity4 = new Activity("Museum Visit", "Visit to the Van Gogh Museum", "Amsterdam", 25.0);

            // Create and save clients
            Client client1 = new Client("Alice", "alice@example.com", "password1", LocalDate.of(1990, JULY, 15));
            Client client2 = new Client("Bob", "bob@example.com", "password2", LocalDate.of(1985, AUGUST, 25));
            clientRepository.saveAll(List.of(client1, client2));

            // Create and save itineraries
            Itinerary itinerary1 = new Itinerary("Summer Vacation", "Exploring Europe", LocalDate.of(2023, JULY, 1), LocalDate.of(2023, JULY, 5),
                    "Paris, France", "Don't forget camera!", "Hotel in Paris (can be more specific/vague)", 200.00, client1, List.of(activity1, activity2));

            Itinerary itinerary2 = new Itinerary("City Break", "Quick getaway", LocalDate.of(2023, AUGUST, 10), LocalDate.of(2023, AUGUST, 15),
                    "Amsterdam", "Reserve restaurant tickets at amsterdameats.com", "TravelLodge", 150.00, client2, List.of(activity3, activity4));
            itinerary1.calculateEstimatedCost();
            itinerary2.calculateEstimatedCost();
            itineraryRepository.saveAll(List.of(itinerary1, itinerary2));

        };
    }
}