package com.example.travelpal.controller;

import com.example.travelpal.service.ItineraryService;
import com.example.travelpal.models.Itinerary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/itinerary")
public class ItineraryController {

    private ItineraryService itineraryService;

    @Autowired
    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    // Combined endpoint to retrieve itineraries conditionally based on clientId
    @GetMapping
    public List<Itinerary> getItineraries(@RequestParam(required = false) Long clientId) {
        if (clientId != null) {
            // Endpoint to retrieve itineraries for the authenticated client
            //THIS IS NOT SECURE YET
            return itineraryService.getItinerariesByClientId(clientId);
        } else {
            return itineraryService.getItineraries();
        }
    }

    @GetMapping(path = "{itineraryId}")
    public Itinerary getItineraryById(@PathVariable("itineraryId") Long itineraryId) { return itineraryService.getItineraryById(itineraryId); }

    @PostMapping
    public void registerItinerary(@RequestBody Itinerary itinerary){
        itineraryService.addNewItinerary(itinerary);
    }

    @DeleteMapping(path = "{itineraryId}")
    public void deleteItinerary(@PathVariable("itineraryId") Long itineraryId){
        itineraryService.deleteItinerary(itineraryId);
    }

    @PutMapping(path = "{itineraryId}")
    public void updateItinerary (@PathVariable ("itineraryId") Long itineraryId, @RequestBody Itinerary itinerary){
        itineraryService.updateItinerary(itinerary, itineraryId);
    }
}
