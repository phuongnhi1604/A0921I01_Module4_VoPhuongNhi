package com.codegym.blog_management.service;

import com.codegym.blog_management.model.Blog;

import java.util.Optional;

public interface BlogService {
    Iterable<Blog> findAll();
    Optional<Blog> findById(Long id);
    Iterable<Blog> findBlogByCategoryID(Long id);
}
