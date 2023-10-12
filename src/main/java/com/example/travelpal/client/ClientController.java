package com.example.travelpal.client;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping
    public void registerClient(@RequestBody Client client){
        clientService.addNewClient(client);
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
