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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired //Will magically instantiate ClientService
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
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
    public void updateClient(@RequestBody Client client,
                             @PathVariable("clientid") Long clientId){
        clientService.updateClient(client, clientId);
    }
}
