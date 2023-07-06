package com.example.ms.client.controllers.dtos.responses;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "This is the entity used when retrieving all the clients from the database")
public class GetAllClientsResponse {

    @ApiModelProperty(value = "The id of the client")
    private Long id;

    @ApiModelProperty(value = "The first name of the client")
    private String firstName;

    @ApiModelProperty(value = "The last name of the client")
    private String lastName;
}
