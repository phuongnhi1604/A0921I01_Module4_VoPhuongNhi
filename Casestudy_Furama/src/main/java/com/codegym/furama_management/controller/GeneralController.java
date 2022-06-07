package com.codegym.furama_management.controller;

import com.codegym.furama_management.model.User;
import com.codegym.furama_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.List;

@Controller
@SessionAttributes("user")
public class GeneralController {
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(){
        return "login/home";
    }

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login/login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("user") User user, Model model) {
        List<User> users = userService.findAll();
        String errorMessage = null;
        for (User user1 : users) {
            if (!user.getUsername().equals(user1.getUsername())){
                errorMessage = "User not found";
            }else if (!user.getPassword().equals(user1.getPassword())){
                errorMessage = "Password don't correct";
            }else {
                return "redirect:/home";
            }
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login/login";
    }
}
