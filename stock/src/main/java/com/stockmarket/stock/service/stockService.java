package com.stockmarket.stock.service;


import com.stockmarket.stock.entity.*;
import com.stockmarket.stock.repository.stockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class stockService {
    @Autowired
    private MongoTemplate mongoTemplate;



    @Autowired
    private stockRepository stockRepository;


    public stockEntity addStock(stockEntity stock) {
        log.info("Inside add stock service");

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(stock.getCompanyCode()));
        List<? extends companyEntity> data = mongoTemplate.find(query, companyEntity.class, "company");
        if (!data.isEmpty()) {
            return stockRepository.save(stock);
        } else {
            return new stockEntity();
        }

    }

    public List<? extends stockEntity> getStock(Long companyCode, String startDate, String endDate) {


        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date Start_date = formatter.parse(startDate);
            Date End_date = formatter.parse(endDate);
            Query query = new Query();

            query.addCriteria(Criteria.where("companyCode").is(companyCode).andOperator(Criteria.where("currentDate").gte(Start_date).lt(End_date)));
            List<? extends stockEntity> data = mongoTemplate.find(query, stockEntity.class, "stock");

            return data;
        } catch (Exception ex) {
            return null;
        }


    }
}
