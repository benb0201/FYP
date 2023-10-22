package com.example.travelpal.repository;

import com.example.travelpal.models.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryRepository
        extends JpaRepository<Itinerary, Long> {
}
