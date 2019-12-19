package com.fisc.decletatfinancier3.web.rest;

import com.fisc.decletatfinancier3.service.DecletatfinancierIiiKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decletatfinancier-iii-kafka")
public class DecletatfinancierIiiKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DecletatfinancierIiiKafkaResource.class);

    private DecletatfinancierIiiKafkaProducer kafkaProducer;

    public DecletatfinancierIiiKafkaResource(DecletatfinancierIiiKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
