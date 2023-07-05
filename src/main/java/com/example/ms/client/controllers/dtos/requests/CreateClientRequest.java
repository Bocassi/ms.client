package com.example.ms.client.controllers.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateClientRequest {

    @NotBlank(message = "'firstName' can't be null or blank")
    private String firstName;

    @NotBlank(message = "'lastName' can't be null or blank")
    private String lastName;

    @NotBlank
    @Size(min = 6, max = 12, message = "'dni' is not a valid dni")
    @Pattern(regexp = "\\d+", message = "'dni' is not a valid dni")
    private String dni;

    @Email(message = "'mail' is not a valid email address")
    private String mail;

    @NotBlank(message = "'phone' can't be null or blank")
    @Size(min = 8, max = 20, message = "'phone' is not a valid phone")
    private String phone;
}
