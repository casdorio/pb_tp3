package com.carlos.infnet.product_service.service;

import java.util.List;
import java.util.Optional;

import com.carlos.infnet.product_service.model.Category;
import com.carlos.infnet.product_service.model.Product;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    List<Product> findProductsByCategory(Long categoryId);
}
