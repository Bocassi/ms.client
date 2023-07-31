package com.example.ms.client.controllers.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentMovieRequest {

    @NotBlank (message = "Movie ID must be a positive number")
    @Positive (message = "Movie ID must be a positive number")
    private Long movieId;

    @NotBlank (message = "Client number must contain a valid client number")
    private String clientNumber;
}
