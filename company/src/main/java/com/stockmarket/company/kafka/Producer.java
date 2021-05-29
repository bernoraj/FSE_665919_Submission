package com.stockmarket.company.kafka;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Producer {
    public void publishLog(String message){
        final String baseUrl = "http://message:7001/kafka/company/publish";

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
