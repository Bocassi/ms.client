package com.example.ms.client.messaging;


import com.example.ms.client.controllers.dtos.requests.RentAndReturnMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, RentAndReturnMovieRequest> kafkaRentAndReturnTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, RentAndReturnMovieRequest> kafkaRentAndReturnTemplate) {
        this.kafkaRentAndReturnTemplate = kafkaRentAndReturnTemplate;
    }

    public void sendRentMovie(RentAndReturnMovieRequest rentAndReturnMovieRequest) {

        kafkaRentAndReturnTemplate.send("rent-movie", rentAndReturnMovieRequest);
    }

    public void sendReturnMovie(RentAndReturnMovieRequest rentAndReturnMovieRequest) {

        kafkaRentAndReturnTemplate.send("return-movie", rentAndReturnMovieRequest);
    }
}
