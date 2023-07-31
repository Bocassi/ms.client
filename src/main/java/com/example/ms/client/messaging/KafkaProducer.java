package com.example.ms.client.messaging;


import com.example.ms.client.controllers.dtos.requests.RentMovieRequest;
import com.example.ms.client.controllers.dtos.requests.ReturnMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, RentMovieRequest> kafkaRentTemplate;

    private final KafkaTemplate<String, ReturnMovieRequest> kafkaReturnTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, RentMovieRequest> kafkaRentTemplate, KafkaTemplate<String, ReturnMovieRequest> kafkaReturnTemplate) {
        this.kafkaRentTemplate = kafkaRentTemplate;
        this.kafkaReturnTemplate = kafkaReturnTemplate;
    }

    public void sendRentMovie(RentMovieRequest rentMovieRequest) {

        kafkaRentTemplate.send("rent-movie", rentMovieRequest);
    }

    public void sendReturnMovie(ReturnMovieRequest returnMovieRequest) {

        kafkaReturnTemplate.send("return-movie", returnMovieRequest);
    }
}
