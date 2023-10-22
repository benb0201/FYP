package com.example.travelpal.service;

import com.example.travelpal.models.Transport;
import com.example.travelpal.repository.TransportRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportService {
    private TransportRepository transportRepository;

    @Autowired
    public TransportService(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    public List<Transport> getTransportation(){
        return transportRepository.findAll();
    }

    public void addNewTransport(Transport transport){
        transportRepository.save(transport);
    }

    public void deleteTransport(Long transportId){
        transportRepository.deleteById(transportId);
    }

    public void updateTransport(Transport transport, Long transportId){
        Optional<Transport> transportOptional = transportRepository.findById(transportId);
        if (transportOptional.isEmpty()) {
            throw new EntityNotFoundException("Transport with ID " + transportId + " not found");
        }

        // Get the existing transport from the Optional
        Transport existingTransport = transportOptional.get();

        // Update the attributes of the existing transport with the values from the new transport
        existingTransport.setName(transport.getName());
        existingTransport.setDescription(transport.getDescription());
        existingTransport.setType(transport.getType());
        existingTransport.setCost(transport.getCost());
        existingTransport.setDestinations(transport.getDestinations());

        // Save the updated transport back to the repository
        transportRepository.save(existingTransport);
    }
}
