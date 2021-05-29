package com.stockmarket.company.controller;

import com.stockmarket.company.entity.Company;
import com.stockmarket.company.kafka.Producer;
import com.stockmarket.company.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/company")
@Slf4j
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    
    private final Producer producer;

    public CompanyController() {
        producer = new Producer();
    }

    @PostMapping("/register")
    public Company Register(@Valid @RequestBody Company company){
        log.info("Inside Company Register");
        producer.publishLog("Inside Company Register "+ new java.util.Date());
        return companyService.registerCompany(company);
    }

    @GetMapping("/info/{id}")
    public Company Info(@PathVariable("id") Long companyCode){
        log.info("Inside Company Info");
        producer.publishLog("Inside Company Info "+ new java.util.Date());
        return  companyService.findByCompanyCode(companyCode);
    }

    @GetMapping("/getall")
    public List<Company> GetAll(){
        log.info("Inside Company GetAll");
        producer.publishLog("Inside Company GetAll "+ new java.util.Date());
        return  companyService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void Delete(@PathVariable("id") Long companyCode){
        log.info("Inside Delete Company");
        producer.publishLog("Inside Delete Company "+ new java.util.Date());
        companyService.deleteCompany(companyCode);

    }
}
