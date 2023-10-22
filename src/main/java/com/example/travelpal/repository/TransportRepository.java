package com.example.travelpal.repository;

import com.example.travelpal.models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository
        extends JpaRepository<Transport, Long> {
}
