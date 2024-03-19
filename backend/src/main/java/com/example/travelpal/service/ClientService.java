package com.example.travelpal.service;

import com.example.travelpal.dto.LoginDTO;
import com.example.travelpal.dto.RegisterDTO;
import com.example.travelpal.models.Client;
import com.example.travelpal.repository.ClientRepository;
import com.example.travelpal.response.LoginResponse;
import com.example.travelpal.response.RegisterResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Makes this class recognised as a Spring Bean
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    public ClientService(ClientRepository clientRepository, PasswordEncoder encoder) {
        this.clientRepository = clientRepository;
        this.encoder = encoder;
    }

    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client with ID " + clientId + " not found"));
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    // Modified addNewClient method to directly return a RegisterResponse
    public RegisterResponse registerClient(RegisterDTO registerDTO) {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(registerDTO.getEmail());

        if (clientOptional.isPresent()) {
            // If the email is already taken, return a RegisterResponse indicating failure
            return new RegisterResponse("Email is already registered", false);
        }

        // Encode the password before saving to the database
        String encodedPassword = encoder.encode(registerDTO.getPassword());

        // Create a new Client object with the provided details
        Client client1 = new Client(
                registerDTO.getName(),
                registerDTO.getEmail(),
                encodedPassword,
                registerDTO.getDob()
        );

        // Save the new client to the database
        clientRepository.save(client1);
        System.out.println(client1);

        // Return a RegisterResponse indicating successful registration
        return new RegisterResponse("Registration Successful", true);
    }

    public LoginResponse loginClient(LoginDTO loginDTO) {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(loginDTO.getEmail());

        if (clientOptional.isEmpty()) {
            // If no client with the given email exists, indicate email does not exist
            return new LoginResponse("Email does not exist", false);
        }

        Client client = clientOptional.get();
        String password = loginDTO.getPassword(); // Get the entered password from the loginDTO
        String encodedPassword = client.getPassword(); // Get the encoded password from the retrieved client

        // Check if the entered password matches the encoded password
        boolean isPwdRight = encoder.matches(password, encodedPassword);

        // Return a LoginResponse based on the result of finding the client by email and password
        return new LoginResponse(isPwdRight ? "Login Success" : "Password does not match", isPwdRight);
    }


    public void deleteClient(Long clientId) {
        boolean exists = clientRepository.existsById(clientId);
        if(!exists){
            throw new IllegalStateException("Client with id: "+clientId+" does not exist");
        }else clientRepository.deleteById(clientId);
    }

//    @Transactional
    public boolean updateClient(Client client, Long clientId) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isEmpty()) {
//            throw new EntityNotFoundException("Client with ID " + clientId + " not found");
            return false;
        }

        // Get the existing client from the Optional
        Client existingClient = clientOptional.get();

        // Update the attributes of the existing client with the values from the new client
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        existingClient.setDob(client.getDob());

        // Save the updated client back to the repository
        clientRepository.save(existingClient);
        return true;
    }
}
