package com.example.travelpal.itinerary;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryRepository
        extends JpaRepository<Itinerary, Long> {
}
