package com.codegym.blog_management.service;

import com.codegym.blog_management.model.Blog;
import com.codegym.blog_management.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Iterable<Blog> findBlogByCategoryID(Long id) {
        return blogRepository.findBlogByCategoryID(id);
    }
}
