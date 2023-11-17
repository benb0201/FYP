package com.example.travelpal.configuration;

import com.example.travelpal.DestinationList;
import com.example.travelpal.repository.ActivityRepository;
import com.example.travelpal.models.Destination;
import com.example.travelpal.models.Activity;
import com.example.travelpal.repository.DestinationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ActivityConfig {

    @Bean
    public CommandLineRunner activityDataLoader(ActivityRepository activityRepository, DestinationRepository destinationRepository) {
        // Save the destinations to the database
        DestinationList destinationList = new DestinationList();
        destinationRepository.saveAll(destinationList.getDestinations());

        return args -> {
            Activity activity1 = new Activity(
                    "Hiking",
                    "Enjoy the great outdoors by hiking in scenic locations.",
                    "Mountain Trails",
                    "Outdoor",
                    20.0,
                    List.of(destinationList.getAmsterdam())
            );

            Activity activity2 = new Activity(
                    "Museum Visit",
                    "Explore local history and culture in museums.",
                    "Local Museum",
                    "Cultural",
                    10.0,
                    List.of(destinationList.getLondon())
            );

            // Save the activities to the database
            activityRepository.saveAll(List.of(activity1, activity2));
        };
    }
}