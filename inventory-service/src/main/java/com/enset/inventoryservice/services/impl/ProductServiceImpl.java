package com.enset.inventoryservice.services.impl;

import com.enset.inventoryservice.dtos.ProductDto;
import com.enset.inventoryservice.entities.Product;
import com.enset.inventoryservice.exceptions.ProductNotFound;
import com.enset.inventoryservice.repositories.ProductRepository;
import com.enset.inventoryservice.services.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product getProduct(String id) throws ProductNotFound {
        return productRepository.findById(id).orElseThrow(()->new ProductNotFound("This Product doesn't exist !!"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public Product createProduct(ProductDto productDto) {
        return productRepository.save(Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .build());
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
