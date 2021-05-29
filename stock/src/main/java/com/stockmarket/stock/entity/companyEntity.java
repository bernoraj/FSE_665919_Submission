package com.stockmarket.stock.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class companyEntity {


    private Long companyCode;
    private String companyName;

    private String companyCEO;

    private String companyWebsite;

    private Double companyTurnover;

    private String stockEx;
}
