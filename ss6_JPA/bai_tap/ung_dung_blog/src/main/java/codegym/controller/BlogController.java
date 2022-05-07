package codegym.controller;

import codegym.entity.Blog;
import codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/list")
    public String list(Model model){
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs",blogs);
        return "blog/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("blog",new Blog());
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
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/edit";
    }
    @PostMapping("/update")
    public String update(Blog blog){
        blogService.update(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog){
        blogService.delete(blog.getId());
        return "redirect:/blog/list";
    }
}
