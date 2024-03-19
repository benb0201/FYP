package com.example.travelpal.controller;

import com.example.travelpal.dto.LoginDTO;
import com.example.travelpal.dto.RegisterDTO;
import com.example.travelpal.response.LoginResponse;
import com.example.travelpal.response.RegisterResponse;
import com.example.travelpal.service.ClientService;
import com.example.travelpal.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired //Will magically instantiate ClientService
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "/{clientid}")
    public ResponseEntity<Client> getClientById(@PathVariable("clientid") Long clientId) {
        Client client = clientService.getClientById(clientId);
        return ResponseEntity.ok(client);
    }

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerClient(@RequestBody RegisterDTO registerDTO){
        RegisterResponse registerResponse = clientService.registerClient(registerDTO);
        return ResponseEntity.ok(registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginClient(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = clientService.loginClient(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @DeleteMapping(path = "{clientid}")
    public void deleteClient(@PathVariable("clientid") Long clientId){
        clientService.deleteClient(clientId);
    }

    @PutMapping(path = "{clientid}")
    public ResponseEntity<?> updateClient(@RequestBody Client client, @PathVariable("clientid") Long clientId) {
        boolean isUpdated = clientService.updateClient(client, clientId);
        if (isUpdated) {
            return ResponseEntity.ok("Client updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Error updating client");
        }
    }
}
