package com.codegym.blog_management.controller;

import com.codegym.blog_management.model.Category;
import com.codegym.blog_management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("categories",categoryService.findAll());
        return "/category/list";
    }
}
