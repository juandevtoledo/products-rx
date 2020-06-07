package com.devtoledo.produtcdevrxservice.controller;

import com.devtoledo.produtcdevrxservice.model.document.Product;
import com.devtoledo.produtcdevrxservice.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Flux<Product> listProduct() {
        return productService.findAll();
    }

    @PostMapping
    public Mono<ResponseEntity<Product>> createProduct(@RequestBody Product product) {
        return productService.createProduct(product)
                .map(productCreated -> ResponseEntity.ok(product));
    }

    @GetMapping("/name/{name}")
    public Flux<Product> listProductByName(@PathVariable("name") String name) {
        return productService.findCategoryByName(name);
    }

}
