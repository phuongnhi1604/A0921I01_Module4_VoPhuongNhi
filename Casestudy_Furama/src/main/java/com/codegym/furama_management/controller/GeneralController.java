package com.codegym.furama_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {
    @GetMapping("/")
    public String home(){
        return "/home";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "/login/login";
    }
}
