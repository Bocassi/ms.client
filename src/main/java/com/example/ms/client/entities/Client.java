package com.example.ms.client.entities;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel (description = "This entity represents the 'clients' table in the 'client' database")
@Entity
@Table(name = "clients")
public class Client {

    @ApiModelProperty(value = "This property is the 'clients' table auto-generated primary key")
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "The first name of the client", example = "Jane")
    @Column
    private String firstName;

    @ApiModelProperty(value = "The last name of the client", example = "Doe")
    @Column
    private String lastName;

    @ApiModelProperty(value = "The dni of the client", example = "99999999")
    @Column
    private String dni;

    @ApiModelProperty(value = "The email address of the client", example = "janedoe@mail.com")
    @Column
    private String mail;

    @ApiModelProperty(value = "The phone number of the client", example = "+5400000000")
    @Column
    private String phone;

    @ApiModelProperty(value = "An UUID auto-generated client number, truncated at the first '-' ", example = "3af0c14k")
    @Column
    private String clientNumber;

    @PrePersist
    private void generateTruncatedClientNumber() {
        String uuidString = UUID.randomUUID().toString();
        int index = uuidString.indexOf("-");
        clientNumber = uuidString.substring(0, index);
    }
}
