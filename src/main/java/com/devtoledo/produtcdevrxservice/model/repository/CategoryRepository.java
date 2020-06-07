package com.devtoledo.produtcdevrxservice.model.repository;


import com.devtoledo.produtcdevrxservice.model.document.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}
