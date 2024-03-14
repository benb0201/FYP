package com.example.travelpal.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "itineraries")
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itinerary_sequence")
    @SequenceGenerator(name = "itinerary_sequence", sequenceName = "itinerary_sequence", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "location")
    private String location;

    @Column(name = "notes")
    private String notes;

    @Column(name = "accommodation")
    private String accommodation;

    @Column(name = "accommodation_cost")
    private double accommodationCost;

    @Column(name = "estimated_cost")
    private double estimatedCost;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Activity> activities;

    public Itinerary() {
    }
    
    public Itinerary(Long id, String name, String description,
                     LocalDate startDate, LocalDate endDate,
                     String location, String notes,
                     String accommodation, Double accommodationCost,
                     Client client, List<Activity> activities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.notes = notes;
        this.accommodation = accommodation;
        this.accommodationCost = accommodationCost;
        this.client = client;
        this.activities = activities;
    }

    public Itinerary(String name, String description,
                     LocalDate startDate, LocalDate endDate,
                     String location, String notes,
                     String accommodation, Double accommodationCost,
                     Client client, List<Activity> activities) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.notes = notes;
        this.accommodation = accommodation;
        this.accommodationCost = accommodationCost;
        this.client = client;
        this.activities = activities;
    }

    public void calculateEstimatedCost() {
        double totalActivitiesCost = 0.0;
        if (activities==null) this.estimatedCost = this.accommodationCost;
        else {
            for (Activity activity : activities) {
                totalActivitiesCost += activity.getCost();
            }
        }

        // Add the accommodation cost to the total activities cost to get the estimated total cost
        this.estimatedCost = this.accommodationCost + totalActivitiesCost;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public double getAccommodationCost() {
        return accommodationCost;
    }

    public void setAccommodationCost(double accommodationCost) {
        this.accommodationCost = accommodationCost;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location='" + location + '\'' +
                ", notes='" + notes + '\'' +
                ", accommodation='" + accommodation + '\'' +
                ", accommodationCost=" + accommodationCost +
                ", estimatedCost=" + estimatedCost +
                ", client=" + client +
                ", activities=" + activities +
                '}';
    }
}