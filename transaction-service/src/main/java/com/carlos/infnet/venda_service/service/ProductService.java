package com.carlos.infnet.venda_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.carlos.infnet.venda_service.model.Product;

@Service
public class ProductService {
    public Product getProductById(Long id) {
        RestClient restClient = RestClient.create();
        var serverUrl = String.format("http://localhost:8081/product/%d", id) ;
        Product product = restClient.get()
                .uri(serverUrl)
                .retrieve()
                .toEntity(Product.class).getBody();

        return product;        
    }
}
