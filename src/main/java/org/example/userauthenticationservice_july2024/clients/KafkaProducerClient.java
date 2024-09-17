package org.example.userauthenticationservice_july2024.clients;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerClient {

    private KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProducerClient(KafkaTemplate<String,String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic,String message) {
        kafkaTemplate.send(topic,message);
    }
}
