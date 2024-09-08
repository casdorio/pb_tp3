package com.carlos.infnet.product_service.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carlos.infnet.product_service.model.Category;
import com.carlos.infnet.product_service.model.Product;
import com.carlos.infnet.product_service.repository.CategoryRepository;
import com.carlos.infnet.product_service.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
    
    @Override
    public List<Product> findProductsByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return category.getProducts();
    }
}
