package com.codegym.furama_management.controller;

import com.codegym.furama_management.dto.CustomerUseServiceDto;
import com.codegym.furama_management.service.CustomerUseService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customerService")
public class CustomerUseServiceController {
    @Autowired
    private CustomerUseService customerUseService;

    @GetMapping("/list")
    public String list( Model model){
        List<CustomerUseServiceDto> useServiceDto = customerUseService.findALL();
        model.addAttribute("customerUseServiceDto",useServiceDto);
        return "customerService/list";
    }

}
