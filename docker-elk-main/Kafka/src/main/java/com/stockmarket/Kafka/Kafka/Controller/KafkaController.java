package com.stockmarket.Kafka.Kafka.Controller;

import com.stockmarket.Kafka.Kafka.Gress.KafkaProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka/")
public class KafkaController {


    private final KafkaProducer producer;

    public KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("stock/publish")
    public void StockWriteMessageToTopic(@RequestParam("message") String message){
        this.producer.StockWriteMessage(message);

    }

    @PostMapping("company/publish")
    public void CompanyWriteMessageToTopic(@RequestParam("message") String message){
        this.producer.CompanyWriteMessage(message);

    }

}
