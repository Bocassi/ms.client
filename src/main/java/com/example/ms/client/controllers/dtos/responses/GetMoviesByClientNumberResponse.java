package com.example.ms.client.controllers.dtos.responses;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ApiModel(description = "This entity is used to retrieve all the movies rented by one client from the 'movie' database")
public class GetMoviesByClientNumberResponse {

    //@ApiModelProperty(value = "Auto-generated movie ID")
    private Long movieId;

    //@ApiModelProperty(value = "Movie name")
    private String movieName;

    //@ApiModelProperty(value = "States if the movie is available for rental. Default: true")
    private Boolean movieAvailable;

    //@ApiModelProperty(value = "States the client that currently has the movie. Default: null")
    private String clientNumber;
}
