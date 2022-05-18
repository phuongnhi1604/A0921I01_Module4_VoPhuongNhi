package com.codegym.book_management.controller;

import com.codegym.book_management.model.Library;
import com.codegym.book_management.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/list")
    public String list(@PageableDefault(size=1) Pageable pageable, Model model){
        Page<Library> libraries = libraryService.findAllByNativeQuery(pageable);
        model.addAttribute("libraries",libraries);
        return "/library/list";
    }

}
