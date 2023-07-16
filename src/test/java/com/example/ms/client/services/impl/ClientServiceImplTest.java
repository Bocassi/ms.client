package com.example.ms.client.services.impl;

import com.example.ms.client.controllers.dtos.requests.CreateClientRequest;
import com.example.ms.client.controllers.dtos.requests.UpdateClientRequest;
import com.example.ms.client.controllers.dtos.responses.GetAllClientsResponse;
import com.example.ms.client.entities.Client;
import com.example.ms.client.repositories.ClientRepository;
import com.example.ms.client.services.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    private ClientService clientService;

    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        clientService = new ClientServiceImpl(clientRepository, restTemplate);
    }

    @Test
    void createClient() {

        Client client = Client.builder().id(null).clientNumber(null).firstName("TestFirstName").lastName("TestLastName").dni("TestDni").mail("Test@mail.com").phone("TestPhone").build();

        Mockito.when(clientRepository.save(client)).thenReturn(client);
        Client result = clientService.createClient(CreateClientRequest.builder().firstName("TestFirstName").lastName("TestLastName").dni("TestDni").mail("Test@mail.com").phone("TestPhone").build());

        Assertions.assertEquals(client, result);
    }

    @Test
    void getAllClients() {

        List<Client> clientList = List.of(Client.builder().id(1L).clientNumber("ClientNumber1").firstName("TestFirstName").lastName("TestLastName").dni("TestDni").mail("Test@mail.com").phone("TestPhone").build(),
                Client.builder().id(2L).clientNumber("ClientNumber2").firstName("TestFirstName").lastName("TestLastName").dni("TestDni").mail("Test@mail.com").phone("TestPhone").build());

        Mockito.when(clientRepository.findAll()).thenReturn(clientList);

        List<GetAllClientsResponse> responses = new ArrayList<>();

        for (Client client : clientList) {

            GetAllClientsResponse response = new GetAllClientsResponse();

            response.setId(client.getId());
            response.setFirstName(client.getFirstName());
            response.setLastName(client.getLastName());

            responses.add(response);
        }

        List<GetAllClientsResponse> result = clientService.getAllClients();

        Assertions.assertEquals(responses, result);
    }

    @Test
    void getClientById() {

        Client client = Client.builder().id(1L).clientNumber("ClientNumber").firstName("TestFirstName").lastName("TestLastName").dni("TestDni").mail("Test@mail.com").phone("TestPhone").build();

        Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.ofNullable(client));
        Client result = clientService.getClientById(1L);

        Assertions.assertEquals(client, result);
    }

    @Test
    void deleteClient() {

        Client client = Client.builder().id(1L).clientNumber("ClientNumber").firstName("TestFirstName").lastName("TestLastName").dni("TestDni").mail("Test@mail.com").phone("TestPhone").build();

        Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.ofNullable(client));
        clientService.deleteClient(1L);

        Mockito.verify(clientRepository,Mockito.times(1)).deleteById(1L);
    }

    @Test
    void updateClient() {

        Client client = Client.builder().id(1L).clientNumber("ClientNumber").firstName("TestFirstName").lastName("TestLastName").dni("TestDni").mail("Test@mail.com").phone("TestPhone").build();

        Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.ofNullable(client));
        Mockito.when(clientRepository.save(client)).thenReturn(client);
        Client result = clientService.updateClient(1L, UpdateClientRequest.builder().firstName("NewFirstName").lastName("NewLastName").dni("NewDni").mail("NewEmail@mail.com").phone("NewPhone").build());

        Assertions.assertEquals(client, result);
    }

    @Test
    void getClientByIdNotFoundException() {

        Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResponseStatusException.class,()->clientService.getClientById(1L));
    }

    @Test
    void deleteClientNotFoundException() {

        Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResponseStatusException.class,()->clientService.deleteClient(1L));
    }

    @Test
    void updateClientNotFoundException() {

        Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResponseStatusException.class,()->clientService.updateClient(1L,null));
    }

}