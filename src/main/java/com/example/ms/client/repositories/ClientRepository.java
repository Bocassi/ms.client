package com.example.ms.client.repositories;

import com.example.ms.client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByClientNumber(String clientNumber);

    Optional<Client> findClientByClientNumber(String clientNumber);
}
