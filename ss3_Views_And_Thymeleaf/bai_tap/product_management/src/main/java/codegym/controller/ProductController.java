package codegym.controller;

import codegym.entity.Product;
import codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/product/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product) {
        productService.add(product);
        return "redirect:/product/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") String id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/product/view";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") String id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/product/edit";
    }

    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/product/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product) {
        productService.delete(product.getId());
        return "redirect:/product/list";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model){
        model.addAttribute("products",productService.searchName(name));
        return "/product/search";
    }
}
