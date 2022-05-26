package com.codegym.ajax_blog__app.service.Impl;

import com.codegym.ajax_blog__app.model.Blog;
import com.codegym.ajax_blog__app.repository.BlogRepository;
import com.codegym.ajax_blog__app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        List<Blog> blogs = new ArrayList<>();
        blogRepository.findAll().forEach(b -> blogs.add(b));
        return blogs;
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog!=null){
            blogRepository.delete(blog);
        }
    }

    @Override
    public Page<Blog> findByAuthorAndCategory(String author, String category, Pageable pageable) {
        return blogRepository.findByAuthorAndCategory(author,category, pageable);
    }

    @Override
    public Page<Blog> findAllByNativeQuery(Pageable pageable) {
        return blogRepository.findAllByNativeQuery(pageable);
    }

    @Override
    public Page<Blog> sortByPostDate(Pageable pageable) {
        return blogRepository.sortByPostDate(pageable);
    }

    @Override
    public List<Blog> findAllByCategory_Id(Integer id) {
        return blogRepository.findAllByCategory_Id(id);
    }

    @Override
    public List<Blog> findAllByAuthor(String author) {
        return blogRepository.findAllByAuthor(author);
    }
}
