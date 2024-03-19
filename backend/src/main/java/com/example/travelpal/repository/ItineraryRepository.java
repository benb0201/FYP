package com.example.travelpal.repository;

import com.example.travelpal.models.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItineraryRepository
        extends JpaRepository<Itinerary, Long> {
    List<Itinerary> findByClientId(Long clientId);
}
