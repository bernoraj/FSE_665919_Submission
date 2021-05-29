package com.stockmarket.Kafka.Kafka.Gress;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics="Stocklogs", groupId="stock")
    public void getMessage(String message){

        System.out.println(message);

    }

    @KafkaListener(topics="Companylogs", groupId="company")
    public void getMessageCompany(String message){

        System.out.println(message);

    }
}
