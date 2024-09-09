package com.carlos.infnet.vatrate.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.carlos.infnet.vatrate.model.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
    public Product getProductById(Long id) {
        log.info("Total tax cost: {}", id);
        RestClient restClient = RestClient.create();
        var serverUrl = String.format("http://localhost:8081/product/%d", id) ;
        Product product = restClient.get()
                .uri(serverUrl)
                .retrieve()
                .toEntity(Product.class).getBody();

        return product;        
    }
}
