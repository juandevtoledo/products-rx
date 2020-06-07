package com.devtoledo.produtcdevrxservice.model.service;

import com.devtoledo.produtcdevrxservice.model.document.Category;
import com.devtoledo.produtcdevrxservice.model.document.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> findAll();

    Mono<Product> getProduct(String id);

    Mono<Product> createProduct(Product product);

    Mono<Product> updateProduct(Product product);

    Mono<Void> deleteProduct(Product product);

    Mono<Category> createCategory(Category category);

    Mono<Category> updateCategory(Category category);

    Mono<Category> getCategory(String id);

    Mono<Void> deleteCategory(Category category);

    Flux<Category> findCategoryAll();

    Flux<Product> findCategoryByName(String name);
}
