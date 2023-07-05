package com.example.ms.client.controllers;

import com.example.ms.client.controllers.dtos.requests.CreateClientRequest;
import com.example.ms.client.controllers.dtos.requests.UpdateClientRequest;
import com.example.ms.client.controllers.dtos.responses.GetAllClientsResponse;
import com.example.ms.client.entities.Client;
import com.example.ms.client.exceptions.ExceptionController;
import com.example.ms.client.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Validated
@RequestMapping (value = "/client")
public class ClientController extends ExceptionController {

    private ClientService clientService;

    public ClientController(ClientService clientService) { this.clientService = clientService; }

    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody CreateClientRequest createClientRequest) {

        return new ResponseEntity<>(clientService.createClient(createClientRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GetAllClientsResponse>> getAllClients() {

        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable @Positive(message = "'id' must be a positive value") Long id) {

        return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable @Positive(message = "'id' must be a positive value") Long id, @Valid @RequestBody UpdateClientRequest updateClientRequest) {

        return new ResponseEntity<>(clientService.updateClient(id, updateClientRequest), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteClient(@PathVariable @Positive(message = "'id' must be a positive value") Long id) {

        clientService.deleteClient(id);
    }
}
