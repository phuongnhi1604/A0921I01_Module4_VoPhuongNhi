package com.codegym.ajax_blog__app.controller;

import com.codegym.ajax_blog__app.model.Blog;
import com.codegym.ajax_blog__app.model.Category;
import com.codegym.ajax_blog__app.service.BlogService;
import com.codegym.ajax_blog__app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;
//    @GetMapping("/list")
//    public String list(@PageableDefault(size=1) Pageable pageable, Model model){
//        Page<Blog> blogs = blogService.findAllByNativeQuery(pageable);
//        model.addAttribute("blogs",blogs);
//        return "blog/list";
//    }


//    @GetMapping("/list")
//    public String getAllBlog(@RequestParam(defaultValue = "") String key_author,
//                             @RequestParam(defaultValue = "") String key_category, @PageableDefault(size=2) Pageable pageable, Model model) {
//        Page<Blog> blogs = blogService.findByAuthorAndCategory(key_author, key_category, pageable);
//        model.addAttribute("blogs", blogs);
//        model.addAttribute("categories",categoryService.findAll());
//        model.addAttribute("key_author",key_author);
//        model.addAttribute("key_category",key_category);
//        return "blog/list" ;
//    }

    @GetMapping("/list")
    public String getAllBlog(@RequestParam(defaultValue = "") String author
            , Model model) {
        List<Blog> blogs = blogService.findAllByAuthor(author);
        model.addAttribute("blogs", blogs);
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("author",author);
        return "blog/list" ;
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        Blog blog = new Blog();
        blog.setCategory(new Category());
        model.addAttribute("blog",blog);
        model.addAttribute("categories",categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog){
        blogService.create(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") int id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/blog/view";
    }

    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable("id") int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        model.addAttribute("categories",categoryService.findAll());
        return "/blog/edit";
    }
    @PostMapping("/update")
    public String update(Blog blog){
        blogService.update(blog);
        return "redirect:/blog/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id){
        blogService.delete(id);
        return "redirect:/blog/list";
    }

    @GetMapping("/sort")
    public String sortByPostDate(@PageableDefault(size = 2) Pageable pageable,Model model){
        Page<Blog> blogs=blogService.sortByPostDate(pageable);
        model.addAttribute("blogs",blogs);
        return "/blog/list";
    }
}
