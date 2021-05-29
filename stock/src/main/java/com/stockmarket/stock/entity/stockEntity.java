package com.stockmarket.stock.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="stock")
public class stockEntity {

    private Long companyCode;
    @CreatedDate
    private Date currentDate;
    private Integer stockPrice;

}
