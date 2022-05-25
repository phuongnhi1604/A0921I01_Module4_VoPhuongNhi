package com.codegym.blog_management.controller;

import com.codegym.blog_management.model.Blog;
import com.codegym.blog_management.service.BlogService;
import com.codegym.blog_management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public String list(Model model){
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        model.addAttribute("blogs",blogs);
        return "blog/list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") Long id, Model model){
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/blog/view";
    }
}
