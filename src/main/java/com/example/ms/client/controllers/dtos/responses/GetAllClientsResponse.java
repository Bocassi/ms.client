package com.example.ms.client.controllers.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllClientsResponse {

    private Long id;
    private String firstName;
    private String lastName;
}
