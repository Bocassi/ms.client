package com.example.ms.client.services;

import com.example.ms.client.controllers.dtos.requests.CreateClientRequest;
import com.example.ms.client.controllers.dtos.requests.UpdateClientRequest;
import com.example.ms.client.controllers.dtos.responses.GetAllClientsResponse;
import com.example.ms.client.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    Client createClient(CreateClientRequest createClientRequest);

    List<GetAllClientsResponse> getAllClients();

    Client getClientById(Long id);

    void deleteClient(Long id);

    Client updateClient(Long id, UpdateClientRequest updateClientRequest);

}
