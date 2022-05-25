package com.codegym.blog_management.service;

import com.codegym.blog_management.model.Blog;
import com.codegym.blog_management.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Iterable<Category> findAll();
    Optional<Category> findById(Long id);
}
