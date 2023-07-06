package com.example.ms.client.controllers;

import com.example.ms.client.controllers.dtos.requests.CreateClientRequest;
import com.example.ms.client.controllers.dtos.requests.UpdateClientRequest;
import com.example.ms.client.controllers.dtos.responses.GetAllClientsResponse;
import com.example.ms.client.entities.Client;
import com.example.ms.client.exceptions.ExceptionController;
import com.example.ms.client.services.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Validated
@RequestMapping (value = "/client")
@Api(tags = "Clients", description = "Operations related to the clients")
public class ClientController extends ExceptionController {

    private ClientService clientService;

    public ClientController(ClientService clientService) { this.clientService = clientService; }

    @ApiOperation(value = "Create new client", notes = "Creates a new client", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> createClient(@Valid @RequestBody CreateClientRequest createClientRequest) {

        return new ResponseEntity<>(clientService.createClient(createClientRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Gets all clients", notes = "Returns a list of the id, first name and last names of all the clients", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetAllClientsResponse>> getAllClients() {

        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @ApiOperation(value = "Gets a client by id", notes = "Returns all the information of a client based on their id", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClientById(@PathVariable @Positive(message = "'id' must be a positive value") Long id) {

        return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Updates a client", notes = "Updates one or more fields from an existing client", produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> updateClient(@PathVariable @Positive(message = "'id' must be a positive value") Long id, @Valid @RequestBody UpdateClientRequest updateClientRequest) {

        return new ResponseEntity<>(clientService.updateClient(id, updateClientRequest), HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes a client", notes = "Deletes a client", produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteClient(@PathVariable @Positive(message = "'id' must be a positive value") Long id) {

        clientService.deleteClient(id);
    }
}
