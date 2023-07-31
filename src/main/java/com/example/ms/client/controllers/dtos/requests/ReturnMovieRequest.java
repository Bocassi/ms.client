package com.example.ms.client.controllers.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReturnMovieRequest {

    @NotBlank(message = "Movie ID must be a positive number")
    @Positive(message = "Movie ID must be a positive number")
    private Long movieId;
}
