package com.example.travelpal.models;

import com.example.travelpal.models.Client;
import com.example.travelpal.models.Destination;
import jakarta.persistence.*;

import java.time.LocalDate;
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

    @ManyToMany
    @JoinTable(
            name = "itinerary_destinations",
            joinColumns = @JoinColumn(name = "itinerary_id"),
            inverseJoinColumns = @JoinColumn(name = "destination_id")
    )
    private List<Destination> destinations;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Itinerary() {
    }

    public Itinerary(Long id,
                     String name,
                     String description,
                     LocalDate startDate,
                     LocalDate endDate,
                     List<Destination> destinations,
                     Client client) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destinations = destinations;
        this.client = client;
    }

    public Itinerary(String name,
                     String description,
                     LocalDate startDate,
                     LocalDate endDate,
                     List<Destination> destinations,
                     Client client) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destinations = destinations;
        this.client = client;
    }

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

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", destinations=" + destinations +
                ", client=" + client +
                '}';
    }
}
