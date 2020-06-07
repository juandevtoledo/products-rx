package com.devtoledo.produtcdevrxservice.model.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder @AllArgsConstructor @NoArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private String  id;
    @NotNull(message = "numero producto no debe ser vacío")
    private String numberProduct;

    @NotEmpty(message = "El nombre no debe ser vacío")
    private String name;
    private String description;
    @Positive(message = "El stock debe ser mayor que cero")
    private Double stock;
    private Double price;
    private String status;
    private Category category;
}
