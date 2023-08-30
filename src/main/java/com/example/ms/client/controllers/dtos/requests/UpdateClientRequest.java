package com.example.ms.client.controllers.dtos.requests;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ApiModel(description = "This is the entity used to receive the request to update an existing client in the database")
public class UpdateClientRequest {

    //@ApiModelProperty(value = "The first name of the client", example = "Jane")
    @Pattern(regexp = "^(?!\\s*$).+", message = "'firstName' can't consist only of white spaces")
    @Size(min = 2, max = 20, message = "'firstName' doesn't have a valid size")
    private String firstName;

    //@ApiModelProperty(value = "The last name of the client", example = "Doe")
    @Pattern(regexp = "^(?!\\s*$).+", message = "'lastName' can't consist only of white spaces")
    @Size(min = 2, max = 20, message = "'lastName' doesn't have a valid size")
    private String lastName;

    //@ApiModelProperty(value = "The dni of the client. Can only include numbers.", example = "99999999")
    @Size(min = 6, max = 12, message = "'dni' is not a valid dni")
    @Pattern(regexp = "\\d+", message = "'dni' is not a valid dni")
    private String dni;

    //@ApiModelProperty(value = "The email address of the client", example = "janedoe@mail.com")
    @Email(message = "'mail' is not a valid email address")
    private String mail;

    //@ApiModelProperty(value = "The phone number of the client", example = "+5400000000")
    @Pattern(regexp = "^[0-9+\\-\\s]*$", message = "'phone' is not a valid phone")
    @Pattern(regexp = "^(?!\\s*$).+", message = "'phone' can't consist only of white spaces")
    @Size(min = 8, max = 20, message = "'phone' is not a valid phone")
    private String phone;
}
