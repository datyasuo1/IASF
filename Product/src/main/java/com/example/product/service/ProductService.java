package com.example.product.service;

import com.example.product.entity.Products;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Products> findAll(){
        return productRepository.findAll();
    }

    public Optional<Products> findById(String id){
        return productRepository.findById(id);
    }
    public Products save(Products products) {
        return productRepository.save(products);
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
