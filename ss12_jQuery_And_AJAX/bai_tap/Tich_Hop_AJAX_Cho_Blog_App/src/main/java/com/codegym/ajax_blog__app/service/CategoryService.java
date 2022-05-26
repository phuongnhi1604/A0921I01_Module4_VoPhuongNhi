package com.codegym.ajax_blog__app.service;


import com.codegym.ajax_blog__app.model.Category;

import java.util.List;

public interface CategoryService {
    public void create(Category category);
    List<Category> findAll();
    public void update(Category category);
    Category findById(Long id);
    public void delete(Long id);
}
