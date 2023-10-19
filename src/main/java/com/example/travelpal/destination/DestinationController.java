package com.example.travelpal.destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/destination")
public class DestinationController {
    private final DestinationService destinationService;

    @Autowired
    public DestinationController (DestinationService destinationService){
        this.destinationService = destinationService;
    }

    @GetMapping
    public List<Destination> getDestinations(){
        return destinationService.getDestinations();
    }

    @PostMapping
    public void registerDestination(@RequestBody Destination destination){
        destinationService.addNewDestination(destination);
    }

    @DeleteMapping (path = "{destinationid}")
    public void deleteDestination(@PathVariable("destinationid") Long destinationId){
        destinationService.deleteDestination(destinationId);
    }

    @PutMapping (path = "{destinationid}")
    public void updateDestination(@RequestBody Destination destination, @PathVariable("destinationid") Long destinationId){
        destinationService.updateDestination(destination,destinationId);
    }
}
