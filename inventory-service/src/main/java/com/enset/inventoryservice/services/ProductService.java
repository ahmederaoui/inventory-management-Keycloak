package com.enset.inventoryservice.services;

import com.enset.inventoryservice.dtos.ProductDto;
import com.enset.inventoryservice.entities.Product;
import com.enset.inventoryservice.exceptions.ProductNotFound;

import java.util.List;

public interface ProductService {
    Product getProduct(String id) throws ProductNotFound;
    List<Product> getAllProducts();
    Product createProduct(ProductDto productDto);
    void deleteProduct(String id);
}
