package com.example.travelpal.repository;

import com.example.travelpal.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository
        extends JpaRepository<Review, Long> {
}
