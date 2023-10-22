package com.example.travelpal.service;

import com.example.travelpal.models.Destination;
import com.example.travelpal.repository.DestinationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {
    private DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<Destination> getDestinations(){
        return destinationRepository.findAll();
    }

    public void addNewDestination(Destination destination) {
        destinationRepository.save(destination);
        System.out.println(destination);
    }

    public void deleteDestination(Long destinationId) {
        boolean exists = destinationRepository.existsById(destinationId);
        if(!exists){
            throw new IllegalStateException("Destination with id: "+destinationId+" does not exist");
        }else destinationRepository.deleteById(destinationId);
    }

    //    @Transactional
    public void updateDestination(Destination destination, Long destinationId) {
        Optional<Destination> destinationOptional = destinationRepository.findById(destinationId);
        if (destinationOptional.isEmpty()) {
            throw new EntityNotFoundException("Destination with ID " + destinationId + " not found");
        }

        // Get the existing destination from the Optional
        Destination existingDestination = destinationOptional.get();

        // Update the attributes of the existing destination with the values from the new destination
        existingDestination.setName(destination.getName());
        existingDestination.setLocation(destination.getLocation());
        existingDestination.setDescription(destination.getDescription());

        // Save the updated destination back to the repository
        destinationRepository.save(existingDestination);
    }
}
