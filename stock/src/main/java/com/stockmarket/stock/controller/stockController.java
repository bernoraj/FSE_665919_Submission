package com.stockmarket.stock.controller;

import com.stockmarket.stock.entity.stockEntity;
import com.stockmarket.stock.kafka.Producer;
import com.stockmarket.stock.service.stockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/stock")
@Slf4j
public class stockController {
    @Autowired
    private stockService stockService;

    private final Producer producer;

    public stockController() {
        this.producer=new Producer();
    }


    @PostMapping("/add/{id}")
    public stockEntity AddStock(@PathVariable("id") Long companyCode,@RequestBody stockEntity stock){
        log.info("Inside adding Stock");
        producer.publishLog("Inside adding Stock "+ new java.util.Date());
        stock.setCompanyCode(companyCode);
        stock.setCurrentDate(new Date());
        return stockService.addStock(stock);
    }

    @GetMapping("/get/{id}/{sDate}/{eDate}")
    public List<?extends stockEntity> GetStock(@PathVariable("id") Long companyCode, @PathVariable("sDate") String startDate, @PathVariable("eDate") String endDate){
        log.info("Inside Get Stock");
        producer.publishLog("Inside Get Stock "+ new java.util.Date());
        return stockService.getStock(companyCode,startDate,endDate);
    }
}
