package com.example.travelpal.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "transports")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transport_sequence")
    @SequenceGenerator(name = "transport_sequence", sequenceName = "transport_sequence", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private double cost;

    @ManyToMany
    private List<Destination> destinations;

    public Transport() {
    }

    public Transport(Long id, String name, String description, String type, double cost, List<Destination> destinations) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.cost = cost;
        this.destinations = destinations;
    }

    public Transport(String name, String description, String type, double cost, List<Destination> destinations) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.cost = cost;
        this.destinations = destinations;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", cost=" + cost +
                ", destinations=" + destinations +
                '}';
    }
}