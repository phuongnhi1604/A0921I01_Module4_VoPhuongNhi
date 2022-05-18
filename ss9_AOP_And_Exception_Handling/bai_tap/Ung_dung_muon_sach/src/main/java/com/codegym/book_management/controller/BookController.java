package com.codegym.book_management.controller;

import com.codegym.book_management.model.Book;
import com.codegym.book_management.model.Library;
import com.codegym.book_management.service.BookService;
import com.codegym.book_management.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/book/{id}/view")
    public String view(@PathVariable int id, @PageableDefault(size = 2) Pageable pageable, Model model) {
        Page<Book> books = bookService.findAllById(id, pageable);
        model.addAttribute("books", books);
        return "/library/bookList";
    }

    @GetMapping("/book/{book_id}/detail")
    public String detail(@PathVariable int book_id, Model model) {
        Book book = bookService.findById(book_id);
        model.addAttribute("book", book);
        return "/book/detail";
    }

    @PostMapping("/book/borrow")
    public String borrow(@RequestParam("id") int id, Model model) {
        bookService.borrow(id);
//        int codeRandom = (int) Math.floor(((Math.random() * 89999)+10000));
//        model.addAttribute("codeRandom",codeRandom);
        model.addAttribute("id", id);
        return "/book/borrow";
    }

    @GetMapping("/book/return")
    public String showReturn() {
        return "/book/return";
    }

    @PostMapping("/book/return")
    public String repay(@RequestParam("id") int id) {
        bookService.repay(id);
        return "/book/return";
    }

    @GetMapping("/book/create")
    public String showCreate(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("library", libraryService.findAll());
        return "/book/create";
    }

    @PostMapping("/book/create")
    public String create(@ModelAttribute Book book, Model model) {
        bookService.add(book);
        model.addAttribute("book", new Book());
        model.addAttribute("library", libraryService.findAll());
        return "/book/create";
    }
}
