package com.devtoledo.produtcdevrxservice.model.repository;

import com.devtoledo.produtcdevrxservice.model.document.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
