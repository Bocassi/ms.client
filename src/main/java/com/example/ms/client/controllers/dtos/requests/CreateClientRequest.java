package com.example.ms.client.controllers.dtos.requests;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "This is the entity used to receive the request to create a new client in the database")
public class CreateClientRequest {

    @ApiModelProperty(value = "The first name of the client", example = "Jane")
    @NotBlank(message = "'firstName' can't be null or blank")
    private String firstName;

    @ApiModelProperty(value = "The last name of the client", example = "Doe")
    @NotBlank(message = "'lastName' can't be null or blank")
    private String lastName;

    @ApiModelProperty(value = "The dni of the client. Can only include numbers.", example = "99999999")
    @NotBlank
    @Size(min = 6, max = 12, message = "'dni' is not a valid dni")
    @Pattern(regexp = "\\d+", message = "'dni' is not a valid dni")
    private String dni;

    @ApiModelProperty(value = "The email address of the client", example = "janedoe@mail.com")
    @Email(message = "'mail' is not a valid email address")
    private String mail;

    @ApiModelProperty(value = "The phone number of the client", example = "+5400000000")
    @NotBlank(message = "'phone' can't be null or blank")
    @Size(min = 8, max = 20, message = "'phone' is not a valid phone")
    @Pattern(regexp = "^[0-9+\\-\\s]*$", message = "'phone' is not a valid phone")
    private String phone;
}
