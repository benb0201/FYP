package com.example.travelpal.service;

import com.example.travelpal.models.Client;
import com.example.travelpal.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Makes this class recognised as a Spring Bean
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(client.getEmail());
        if(clientOptional.isPresent()){
            throw new IllegalStateException("Client email taken");
        }
        clientRepository.save(client);
        System.out.println(client);
    }

    public void deleteClient(Long clientId) {
        boolean exists = clientRepository.existsById(clientId);
        if(!exists){
            throw new IllegalStateException("Client with id: "+clientId+" does not exist");
        }else clientRepository.deleteById(clientId);
    }

//    @Transactional
    public void updateClient(Client client, Long clientId) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isEmpty()) {
            throw new EntityNotFoundException("Client with ID " + clientId + " not found");
        }

        // Get the existing client from the Optional
        Client existingClient = clientOptional.get();

        // Update the attributes of the existing client with the values from the new client
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        existingClient.setDob(client.getDob());

        // Save the updated client back to the repository
        clientRepository.save(existingClient);
    }
}
