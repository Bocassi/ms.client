package com.example.ms.client.controllers.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateClientRequest {

    @Pattern(regexp = "^(?!\\s*$).+", message = "'firstName' can't consist only of white spaces")
    @Size(min = 2, max = 20, message = "'firstName' doesn't have a valid size")
    private String firstName;

    @Pattern(regexp = "^(?!\\s*$).+", message = "'lastName' can't consist only of white spaces")
    @Size(min = 2, max = 20, message = "'lastName' doesn't have a valid size")
    private String lastName;

    @Size(min = 6, max = 12, message = "'dni' is not a valid dni")
    @Pattern(regexp = "\\d+", message = "'dni' is not a valid dni")
    private String dni;

    @Email(message = "'mail' is not a valid email address")
    private String mail;

    @Pattern(regexp = "^(?!\\s*$).+", message = "'phone' can't consist only of white spaces")
    @Size(min = 8, max = 20, message = "'phone' is not a valid phone")
    private String phone;
}
