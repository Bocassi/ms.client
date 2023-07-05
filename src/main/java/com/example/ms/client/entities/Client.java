package com.example.ms.client.entities;


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
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String dni;

    @Column
    private String mail;

    @Column
    private String phone;

    @Column
    private String clientNumber;

    @PrePersist
    private void generateTruncatedClientNumber() {
        String uuidString = UUID.randomUUID().toString();
        int index = uuidString.indexOf("-");
        clientNumber = uuidString.substring(0, index);
    }
}
