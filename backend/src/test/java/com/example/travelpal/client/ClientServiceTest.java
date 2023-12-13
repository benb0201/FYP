package com.example.travelpal.client;

import com.example.travelpal.dto.RegisterDTO;
import com.example.travelpal.models.Client;
import com.example.travelpal.repository.ClientRepository;
import com.example.travelpal.response.RegisterResponse;
import com.example.travelpal.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

//With this annotation, I won't need to have the autocloseable object (and @AfterEach), as it does it all for me
@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock private ClientRepository repository;
    private PasswordEncoder encoder = new BCryptPasswordEncoder(); // Manually create an instance
    private ClientService service;

    @BeforeEach
    void setUp() {
        service = new ClientService(repository, encoder);
    }

//    @AfterEach
//    void tearDown() throws Exception{
//        autoCloseable.close();
//    }

    @Test
    void getClients() {
        //when
        service.getClients();
        //then
        verify(repository).findAll();
    }

    @Test
    void canAddNewClient() {
        // given
        String email = "friend.org@gmail.com";
        RegisterDTO registerDTO = new RegisterDTO(
                "Friend",
                email,
                "password1",
                LocalDate.of(2000, Month.MARCH, 16)
        );

        // when
        RegisterResponse registerResponse = service.registerClient(registerDTO);

        // then
        assertThat(registerResponse.getStatus()).isTrue();
        assertThat(registerResponse.getMessage()).isEqualTo("Registration Successful");

        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);

        verify(repository).save(clientArgumentCaptor.capture());

        Client capturedClient = clientArgumentCaptor.getValue();

        assertThat(capturedClient.getName()).isEqualTo(registerDTO.getName());
        assertThat(capturedClient.getEmail()).isEqualTo(registerDTO.getEmail());
        // Adjust additional assertions based on your actual Client and RegisterDTO structures
    }


    @Test
    void willReturnFailureResponseWhenEmailIsTaken() {
        // given
        String email = "friend.org@gmail.com";
        RegisterDTO registerDTO = new RegisterDTO(
                "Friend",
                email,
                "password1",
                LocalDate.of(2000, Month.MARCH, 16)
        );
        given(repository.findClientByEmail(registerDTO.getEmail()))
                .willReturn(Optional.of(new Client())); // You can create a dummy Client since the focus is on email existence check

        // when
        RegisterResponse registerResponse = service.registerClient(registerDTO);

        // then
        assertThat(registerResponse.getStatus()).isFalse();
        assertThat(registerResponse.getMessage()).isEqualTo("Email is already registered");

        verify(repository, never()).save(any());
    }




    @Test
    void canDeleteClient() {
        // Given
        long clientId = 3L;

        // Mock the behavior of clientRepository.existsById
        when(repository.existsById(clientId)).thenReturn(true);

        // Mock the behavior of clientRepository.deleteById
        doNothing().when(repository).deleteById(clientId);

        // When
        service.deleteClient(clientId);

        // Then
        verify(repository).existsById(clientId);
        verify(repository).deleteById(clientId);
    }

    @Test
    void willThrowWhenClientNotFoundById() {
        // Given
        long clientId = 3L; // Assuming a client with this ID does not exist

        // When and Then
        assertThatThrownBy(() -> service.deleteClient(clientId))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Client with id: " + clientId + " does not exist");
    }

//    @Test
//    void canUpdateClient() {
//        //given
//        String email = "friend.org@gmail.com";
//        Client client = new Client(
//                "Friend",
//                email,
//                "password1",
//                LocalDate.of(2000, Month.MARCH, 16)
//        );
//        long clientId = 3L; // Assuming a client with this ID exists
//
//        //Mock Client existing
//        when(repository.existsById(clientId)).thenReturn(true);
//
//        // Mock the behavior of repository.ById
//        doNothing().when(repository).deleteById(clientId);
//
//    }

    @Test
    void willThrowIfClientDoesNotExist() {
        //given
        String email = "friend.org@gmail.com";
        Client client = new Client(
                "Friend",
                email,
                "password1",
                LocalDate.of(2000, Month.MARCH, 16)
        );
        long clientId = 3L; // Assuming a client with this ID does not exist

        //Mock Client not existing
        when(repository.findById(clientId)).thenReturn(Optional.empty());

        // When and Then
        assertThatThrownBy(() -> service.updateClient(client, clientId))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("Client with ID " + clientId + " not found");
    }

}