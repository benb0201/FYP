package com.example.travelpal.repository;

import com.example.travelpal.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository
        extends JpaRepository<Activity, Long> {

}
