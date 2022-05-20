package com.codegym.cart_management.service.Impl;

import com.codegym.cart_management.model.Product;
import com.codegym.cart_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductService productService;

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productService.findById(id);
    }

}
