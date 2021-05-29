package com.stockmarket.company.service;

import com.stockmarket.company.entity.Company;
import com.stockmarket.company.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company registerCompany(Company company) {
        log.info("Inside company register service");
        return  companyRepository.save(company);
    }


    public Company findByCompanyCode(Long companyCode) {
        log.info("Inside find company service");
        return  companyRepository.findByCompanyCode(companyCode);
    }

    public List<Company> getAll() {
        log.info("Inside get all company service");
        return  companyRepository.findAll();
    }

    public void deleteCompany(Long companyCode) {
        log.info("Inside delete company service");
        companyRepository.deleteById(companyCode);
    }
}
