package com.devtoledo.produtcdevrxservice.model.service;

import com.devtoledo.produtcdevrxservice.model.document.Category;
import com.devtoledo.produtcdevrxservice.model.document.Product;
import com.devtoledo.produtcdevrxservice.model.repository.CategoryRepository;
import com.devtoledo.produtcdevrxservice.model.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll(

        ).map(product -> {
            product.setName(product.getName().toUpperCase());
            return product;
        }).doOnNext(
                product -> log.info("product " + product.getName())
        );
    }

    @Override
    public Mono<Product> getProduct(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Void> deleteProduct(Product product) {
        return productRepository.delete(product);
    }

    @Override
    public Mono<Category> createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Mono<Category> updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Mono<Category> getCategory(String id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteCategory(Category category) {
        return categoryRepository.delete(category);
    }

    @Override
    public Flux<Category> findCategoryAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Flux<Product> findCategoryByName(String name) {
        return productRepository.findAll()
                .filter(product -> name.equals(product.getName()))
                .map(product -> {
                    product.getName().contains(" - MDF");
                    return product;
                });
    }


}
