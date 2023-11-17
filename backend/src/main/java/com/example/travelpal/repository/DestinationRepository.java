package com.example.travelpal.repository;

import com.example.travelpal.models.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository
        extends JpaRepository<Destination, Long> {
}
