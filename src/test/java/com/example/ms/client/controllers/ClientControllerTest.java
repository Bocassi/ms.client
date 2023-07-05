package com.example.ms.client.controllers;

import com.example.ms.client.controllers.dtos.requests.CreateClientRequest;
import com.example.ms.client.controllers.dtos.requests.UpdateClientRequest;
import com.example.ms.client.controllers.dtos.responses.GetAllClientsResponse;
import com.example.ms.client.entities.Client;
import com.example.ms.client.services.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClientControllerTest {

    @Mock
    ClientService clientService;

    ClientController clientController;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        clientController = new ClientController(clientService);
    }

    @Test
    void createClient() {

        CreateClientRequest createClientRequest = CreateClientRequest.builder().firstName("TestFirstName").lastName("TestLastName").dni("TestDni").mail("Test@mail.com").phone("TestPhone").build();
        Client client = Client.builder().id(null).clientNumber(null).firstName("TestFirstName").lastName("TestLastName").dni("TestDni").mail("Test@mail.com").phone("TestPhone").build();

        Mockito.when(clientService.createClient(createClientRequest)).thenReturn(client);
        ResponseEntity<Client> result = clientController.createClient(createClientRequest);

        Mockito.verify(clientService).createClient(createClientRequest);
        assert result.getStatusCode() == HttpStatus.CREATED;
        assert result.getBody().equals(client);
    }

    @Test
    void getAllClients() {

        List<Client> clientList = List.of(Client.builder().id(1L).clientNumber("ClientNumber1").firstName("TestFirstName").lastName("TestLastName").dni("TestDni").mail("Test@mail.com").phone("TestPhone").build(),
                Client.builder().id(2L).clientNumber("ClientNumber2").firstName("TestFirstName").lastName("TestLastName").dni("TestDni").mail("Test@mail.com").phone("TestPhone").build());

        List<GetAllClientsResponse> responses = new ArrayList<>();

        for (Client client : clientList) {

            GetAllClientsResponse response = new GetAllClientsResponse();

            response.setId(client.getId());
            response.setFirstName(client.getFirstName());
            response.setLastName(client.getLastName());

            responses.add(response);
        }

        Mockito.when(clientService.getAllClients()).thenReturn(responses);


        ResponseEntity<List<GetAllClientsResponse>> result = clientController.getAllClients();

        Mockito.verify(clientService).getAllClients();
        assert result.getStatusCode() == HttpStatus.OK;
        assert result.getBody().equals(responses);
    }

    @Test
    void getClientById() {

        Client client = Client.builder().id(1L).clientNumber("ClientNumber").firstName("TestFirstName").lastName("TestLastName").dni("TestDni").mail("Test@mail.com").phone("TestPhone").build();

        Mockito.when(clientService.getClientById(1L)).thenReturn(client);
        ResponseEntity<Client> result = clientController.getClientById(1L);

        Mockito.verify(clientService).getClientById(1L);
        assert result.getStatusCode() == HttpStatus.OK;
        assert result.getBody().equals(client);
    }

    @Test
    void deleteClient() {

        Mockito.doNothing().when(clientService).deleteClient(1L);

        clientController.deleteClient(1L);
        Mockito.verify(clientService,Mockito.times(1)).deleteClient(1L);
    }

    @Test
    void updateClient() {

        Client client = Client.builder().id(1L).clientNumber("ClientNumber").firstName("TestFirstName").lastName("TestLastName").dni("TestDni").mail("Test@mail.com").phone("TestPhone").build();
        UpdateClientRequest updateClientRequest = UpdateClientRequest.builder().firstName("NewFirstName").lastName("NewLastName").dni("NewDni").mail("NewEmail@mail.com").phone("NewPhone").build();

        Mockito.when(clientService.updateClient(1L, updateClientRequest)).thenReturn(client);
        ResponseEntity<Client> result = clientController.updateClient(1L, updateClientRequest);

        Mockito.verify(clientService).updateClient(1L, updateClientRequest);
        assert result.getStatusCode() == HttpStatus.OK;
        assert result.getBody().equals(client);
    }
}