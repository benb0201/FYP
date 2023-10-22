package com.example.travelpal.service;

import com.example.travelpal.models.Itinerary;
import com.example.travelpal.repository.ItineraryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItineraryService {
    private ItineraryRepository itineraryRepository;

    @Autowired
    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public List<Itinerary> getItineraries(){
        return itineraryRepository.findAll();
    }

    public void addNewItinerary(Itinerary itinerary) {
        itineraryRepository.save(itinerary);
        System.out.println(itinerary);
    }

    public void deleteItinerary(Long itineraryId) {
        boolean exists = itineraryRepository.existsById(itineraryId);
        if(!exists){
            throw new IllegalStateException("Itinerary with id: "+itineraryId+" does not exist");
        }else itineraryRepository.deleteById(itineraryId);
    }

    //    @Transactional
    public void updateItinerary(Itinerary itinerary, Long itineraryId) {
        Optional<Itinerary> itineraryOptional = itineraryRepository.findById(itineraryId);
        if (itineraryOptional.isEmpty()) {
            throw new EntityNotFoundException("Itinerary with ID " + itineraryId + " not found");
        }

        // Get the existing itinerary from the Optional
        Itinerary existingItinerary = itineraryOptional.get();

        // Update the attributes of the existing itinerary with the values from the new itinerary
        existingItinerary.setName(itinerary.getName());
        existingItinerary.setDescription(itinerary.getDescription());
        existingItinerary.setStartDate(itinerary.getStartDate());
        existingItinerary.setEndDate(itinerary.getEndDate());
        existingItinerary.setDestinations(itinerary.getDestinations());
        existingItinerary.setClient(itinerary.getClient());

        // Save the updated itinerary back to the repository
        itineraryRepository.save(existingItinerary);
    }
}
