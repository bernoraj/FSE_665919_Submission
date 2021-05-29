package com.stockmarket.company.repository;

import com.stockmarket.company.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company,Long> {
    Company findByCompanyCode(Long companyCode);

}
