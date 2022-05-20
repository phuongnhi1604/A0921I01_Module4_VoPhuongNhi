package com.codegym.cart_management.service;

import com.codegym.cart_management.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
