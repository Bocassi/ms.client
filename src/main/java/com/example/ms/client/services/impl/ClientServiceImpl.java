package com.example.ms.client.services.impl;

import com.example.ms.client.controllers.dtos.requests.CreateClientRequest;
import com.example.ms.client.controllers.dtos.requests.UpdateClientRequest;
import com.example.ms.client.controllers.dtos.responses.GetAllClientsResponse;
import com.example.ms.client.entities.Client;
import com.example.ms.client.repositories.ClientRepository;
import com.example.ms.client.services.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

     private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) { this.clientRepository = clientRepository; }
    @Override
    public Client createClient(CreateClientRequest createClientRequest) {

            Client client = Client.builder()
                    .firstName(createClientRequest.getFirstName())
                    .lastName(createClientRequest.getLastName())
                    .dni(createClientRequest.getDni())
                    .mail(createClientRequest.getMail())
                    .phone(createClientRequest.getPhone())
                    .build();

        return clientRepository.save(client);
    }

    @Override
    public List<GetAllClientsResponse> getAllClients() {

        List<Client> clients = clientRepository.findAll();
        List<GetAllClientsResponse> responses = new ArrayList<>();

        for (Client client : clients) {

            GetAllClientsResponse response = new GetAllClientsResponse();

            response.setId(client.getId());
            response.setFirstName(client.getFirstName());
            response.setLastName(client.getLastName());

            responses.add(response);
        }
        return responses;
    }

    @Override
    public Client getClientById(Long id) {

        Optional<Client> client = clientRepository.findById(id);

        if(client.isPresent()) {

            return client.get();
        }   else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");

    }

    @Override
    public void deleteClient(Long id) {

        Optional<Client> client = clientRepository.findById(id);

        if(client.isPresent()) {

            clientRepository.deleteById(id);
        }   else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");

    }

    @Override
    public Client updateClient(Long id, UpdateClientRequest updateClientRequest) {

        Optional<Client> optionalClient = clientRepository.findById(id);

        if(optionalClient.isPresent()) {

            Client client = optionalClient.get();

            if (updateClientRequest.getFirstName() != null) {

                client.setFirstName(updateClientRequest.getFirstName());
            };

            if (updateClientRequest.getLastName() != null) {

                client.setLastName(updateClientRequest.getLastName());
            };

            if (updateClientRequest.getDni() != null) {

                client.setDni(updateClientRequest.getDni());
            };

            if (updateClientRequest.getMail() != null) {

                client.setMail(updateClientRequest.getMail());
            };

            if (updateClientRequest.getPhone() != null) {

                client.setPhone(updateClientRequest.getPhone());
            };
            return clientRepository.save(client);

        }   else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
    }
}
