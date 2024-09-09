package com.carlos.infnet.venda_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.carlos.infnet.venda_service.model.Item;

@Service
public class TaxService {
    public String getTaxByItems(Item Item) {
        RestClient restClient = RestClient.create();
        var serverUrl = String.format("http://localhost:8084/") ;
        var test = restClient.post()
                .uri(serverUrl)
                .body(Item)
                .retrieve()
                .toEntity(String.class).getBody();

        return test;

}
}
