package com.example.travelpal.controller;

import com.example.travelpal.models.Transport;
import com.example.travelpal.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "api/v1/transport")
public class TransportController {

    private TransportService transportService;

    @Autowired
    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping
    public List<Transport> getTransportation(){
        return transportService.getTransportation();
    }

    @PostMapping
    public void registerTransport(@RequestBody Transport transport){
        transportService.addNewTransport(transport);
    }

    @DeleteMapping(path = "{transportid}")
    public void deleteTransport(@PathVariable Long transportId){
        transportService.deleteTransport(transportId);
    }

    @PutMapping(path = "{transportid}")
    public void updateTransport(@RequestBody Transport transport, @PathVariable Long transportId){
        transportService.updateTransport(transport, transportId);
    }
}
