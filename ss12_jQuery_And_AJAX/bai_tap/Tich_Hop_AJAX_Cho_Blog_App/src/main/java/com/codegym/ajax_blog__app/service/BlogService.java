package com.codegym.ajax_blog__app.service;

import com.codegym.ajax_blog__app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    public void create(Blog blog);
    List<Blog> findAll();
    public void update(Blog blog);
    Blog findById(int id);
    public void delete(int id);
    Page<Blog> findByAuthorAndCategory(String author, String category, Pageable pageable);
    Page<Blog> findAllByNativeQuery(Pageable pageable);
    Page<Blog> sortByPostDate(Pageable pageable);

    List<Blog> findAllByCategory_Id(Integer id);
    List<Blog> findAllByAuthor(String author);
}
