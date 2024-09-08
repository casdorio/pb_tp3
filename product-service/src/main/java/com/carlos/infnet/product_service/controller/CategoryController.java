package com.carlos.infnet.product_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.infnet.product_service.model.Category;
import com.carlos.infnet.product_service.model.Product;
import com.carlos.infnet.product_service.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/public")
@Tag(name = "Category API", description = "API para gerenciar categorias")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    @Operation(summary = "Listar todas as categorias", description = "Retorna uma lista de todas as categorias disponíveis")
    @ApiResponse(responseCode = "200", description = "Lista de categorias retornada com sucesso")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    @Operation(summary = "Encontrar uma categoria por ID", description = "Retorna a categoria com o ID fornecido")
    @ApiResponse(responseCode = "200", description = "Categoria encontrado")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrado")
    public Optional<Category> findById(@PathVariable @Parameter(description = "ID da Categoria") Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/category/{id}/products")
    @Operation(summary = "Listar produtos por categoria", description = "Retorna uma lista de produtos relacionados a uma categoria específica")
    @ApiResponse(responseCode = "200", description = "Produtos da categoria retornados com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public List<Product> getProductsByCategory(
        @PathVariable @Parameter(description = "ID da categoria cujos produtos devem ser retornados") Long categoryId) {
        return categoryService.findProductsByCategory(categoryId);
    }
}
