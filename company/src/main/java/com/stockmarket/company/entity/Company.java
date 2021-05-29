package com.stockmarket.company.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "company")
public class Company {

    @Id
    private Long companyCode;

    @NotNull(message = "Company Name cannot not be null")
    private String companyName;
    @NotNull(message = "Company CEO name cannot not be null")
    private String companyCEO;
    @NotNull(message = "Company Website cannot not be null")
    private String companyWebsite;
    @NotNull(message = "Company Turnover cannot not be null")
    private Double companyTurnover;
    @NotNull(message = "Stock Exchange value cannot not be null")
    private String stockEx;

}
