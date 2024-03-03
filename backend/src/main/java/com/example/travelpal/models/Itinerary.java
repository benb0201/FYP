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

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Adding a list of activities to the itinerary
//    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
//    @JoinTable(
//            name = "itinerary_activities",
//            joinColumns = @JoinColumn(name = "itinerary_id"),
//            inverseJoinColumns = @JoinColumn(name = "activity_id")
//    )
//    @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<Activity> activities;

    public Itinerary() {
    }

    //Constructors without Activities as parameters
    public Itinerary(Long id, String name, String description, LocalDate startDate, LocalDate endDate, String location, String notes, Client client) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.notes = notes;
        this.client = client;
        // Initialize the list to avoid null pointer exceptions when adding activities later
        this.activities = new ArrayList<>();
    }

    public Itinerary(String name, String description, LocalDate startDate, LocalDate endDate, String location, String notes, Client client) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.notes = notes;
        this.client = client;
        // Initialize the list to avoid null pointer exceptions when adding activities later
        this.activities = new ArrayList<>();
    }

    // Include activities in constructors if necessary
    public Itinerary(Long id, String name, String description, LocalDate startDate, LocalDate endDate, String location, String notes, Client client, List<Activity> activities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.notes = notes;
        this.client = client;
        this.activities = activities;
    }

    public Itinerary(String name, String description, LocalDate startDate, LocalDate endDate, String location, String notes, Client client, List<Activity> activities) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.notes = notes;
        this.client = client;
        this.activities = activities;
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
                ", client=" + client +
                ", activities=" + activities +
                '}';
    }
}