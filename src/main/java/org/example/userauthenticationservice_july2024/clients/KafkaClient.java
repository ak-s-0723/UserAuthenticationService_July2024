package org.example.userauthenticationservice_july2024.clients;

import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;

@Component
public class KafkaClient {

    //data type of topic
    //data type of message
    private KafkaTemplate<String,String> kafkaTemplate;

    public KafkaClient(KafkaTemplate<String,String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

   public void sendMessage(String topic,String message) {
        kafkaTemplate.send(topic,message);
   }
}
