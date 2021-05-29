package com.stockmarket.Kafka.Kafka.Gress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {



    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void StockWriteMessage(String msg){
        String TOPIC= "Stocklogs";
        this.kafkaTemplate.send(TOPIC, msg);
    }

    public void CompanyWriteMessage(String msg){
        String TOPIC= "Companylogs";
        this.kafkaTemplate.send(TOPIC, msg);
    }
}
