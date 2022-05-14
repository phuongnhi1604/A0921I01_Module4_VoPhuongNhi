package com.codegym.form_dang_ky.controller;

import com.codegym.form_dang_ky.model.User;
import com.codegym.form_dang_ky.model.UserDto;
import com.codegym.form_dang_ky.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String showForm(Model model){
        model.addAttribute("userDto",new UserDto());
        return "/index";
    }

    @PostMapping("/validateUser")
    public String signIn(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult){
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/index";
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            userService.add(user);
            return "/result";
        }
    }
}
