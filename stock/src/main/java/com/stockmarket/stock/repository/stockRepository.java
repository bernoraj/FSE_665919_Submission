package com.stockmarket.stock.repository;

import com.stockmarket.stock.entity.stockEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface stockRepository extends MongoRepository<stockEntity,Long> {
}
