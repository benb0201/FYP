package com.example.travelpal.itinerary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/itinerary")
public class ItineraryController {

    private ItineraryService itineraryService;

    @Autowired
    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @GetMapping
    public List<Itinerary> getItineraries(){
        return itineraryService.getItineraries();
    }

    @PostMapping
    public void registerItinerary(@RequestBody Itinerary itinerary){
        itineraryService.addNewItinerary(itinerary);
    }

    @DeleteMapping(path = "{itineraryid}")
    public void deleteItinerary(@PathVariable("itineraryid") Long itineraryId){
        itineraryService.deleteItinerary(itineraryId);
    }

    @PutMapping(path = "{itineraryid}")
    public void updateItinerary (@PathVariable ("itineraryid") Long itineraryId, @RequestBody Itinerary itinerary){
        itineraryService.updateItinerary(itinerary, itineraryId);
    }
}
