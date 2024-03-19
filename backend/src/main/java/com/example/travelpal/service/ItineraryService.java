package com.example.travelpal.service;

import com.example.travelpal.models.Activity;
import com.example.travelpal.models.Itinerary;
import com.example.travelpal.repository.ItineraryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItineraryService {
    private ItineraryRepository itineraryRepository;

    @Autowired
    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    // Adding method to retrieve itineraries by the client ID
    public List<Itinerary> getItinerariesByClientId(Long clientId) {
        return itineraryRepository.findByClientId(clientId);
    }
    public List<Itinerary> getItineraries(){ return itineraryRepository.findAll(); }

    public Itinerary getItineraryById(Long itineraryId) {
        return itineraryRepository.findById(itineraryId)
                .orElseThrow(() -> new EntityNotFoundException("Itinerary with ID " + itineraryId + " not found"));
    }

    public void addNewItinerary(Itinerary itinerary) {
        itinerary.calculateEstimatedCost(); // Calculate the estimated cost before saving
        itineraryRepository.save(itinerary);
        System.out.println(itinerary);
    }

    public void deleteItinerary(Long itineraryId) {
        boolean exists = itineraryRepository.existsById(itineraryId);
        if(!exists){
            throw new IllegalStateException("Itinerary with id: "+itineraryId+" does not exist");
        }else itineraryRepository.deleteById(itineraryId);
    }

        @Transactional
    public void updateItinerary(Itinerary updatedItinerary, Long itineraryId) {
        Optional<Itinerary> itineraryOptional = itineraryRepository.findById(itineraryId);
        if (itineraryOptional.isEmpty()) {
            throw new EntityNotFoundException("Itinerary with ID " + itineraryId + " not found");
        }

        // Get the existing itinerary from the Optional
        Itinerary existingItinerary = itineraryOptional.get();

        // Update the attributes of the existing itinerary with the values from the new itinerary
        existingItinerary.setName(updatedItinerary.getName());
        existingItinerary.setDescription(updatedItinerary.getDescription());
        existingItinerary.setStartDate(updatedItinerary.getStartDate());
        existingItinerary.setEndDate(updatedItinerary.getEndDate());
        existingItinerary.setLocation(updatedItinerary.getLocation());
        existingItinerary.setNotes(updatedItinerary.getNotes());
        existingItinerary.setAccommodation(updatedItinerary.getAccommodation());
        existingItinerary.setAccommodationCost(updatedItinerary.getAccommodationCost());

        // Update the activities
        existingItinerary.getActivities().clear(); // Clear the current list
        existingItinerary.getActivities().addAll(updatedItinerary.getActivities());
        existingItinerary.calculateEstimatedCost(); // Recalculate the estimated cost with the updates

        // No need to explicitly save the object due to the @Transactional annotation
//         The changes will be automatically persisted at the end of the transaction
////         Save the updated itinerary back to the repository
//        itineraryRepository.save(existingItinerary);
    }
}
