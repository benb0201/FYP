package com.example.travelpal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_sequence")
    @SequenceGenerator(name = "activity_sequence", sequenceName = "activity_sequence", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private String location;

    private double cost;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "itinerary_id")
//    @JsonBackReference
//    private Itinerary itinerary; // The reference to the Itinerary

    public Activity() {
    }

    // Constructor without itinerary
    public Activity(String name, String description, String location, double cost) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.cost = cost;
        // itinerary is not set and can be set later
    }

    // Constructor with itinerary
    public Activity(String name, String description, String location, double cost, Itinerary itinerary) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.cost = cost;
    }

    // Optionally, keep the constructor with the ID for internal use or specific cases
    public Activity(Long id, String name, String description, String location, double cost, Itinerary itinerary) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.cost = cost;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", cost=" + cost +
                '}';
    }
}