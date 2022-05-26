package com.codegym.ajax_blog__app.restcontroller;


import com.codegym.ajax_blog__app.model.Blog;
import com.codegym.ajax_blog__app.model.Category;
import com.codegym.ajax_blog__app.service.BlogService;
import com.codegym.ajax_blog__app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogRestController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> findAllBlog() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Blog>>(blogList, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/blogs/category/{id}")
    public ResponseEntity<List<Blog>> findAllBlogByCategory(@PathVariable("id") Integer id){
        List<Blog> blogList = blogService.findAllByCategory_Id(id);
        if(blogList.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable("id") Integer id){
        Blog blog = blogService.findById(id);
        if(blog==null){
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog,HttpStatus.OK);
    }

    @GetMapping("/blogs/searchAuthor")
    public ResponseEntity<List<Blog>> findBlogByAuthor(@PathVariable("searchAuthor") String author){
        List<Blog> blogs = blogService.findAllByAuthor(author);
        if(blogs.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
    }
}
