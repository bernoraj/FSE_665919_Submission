package com.stockmarket.stock.kafka;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Producer {
    public void publishLog(String message){
        final String baseUrl = "http://message:7001/kafka/stock/publish";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        try{
            MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
            map.add("message", message);
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

            ResponseEntity<String> response = restTemplate.postForEntity( baseUrl, request , String.class );

        }catch (Exception ex)
        {

            System.out.println(ex);

        }


    }

}
