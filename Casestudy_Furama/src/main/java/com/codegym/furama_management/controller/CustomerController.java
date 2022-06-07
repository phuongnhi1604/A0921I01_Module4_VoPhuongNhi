package com.codegym.furama_management.controller;

import com.codegym.furama_management.model.Customer;
import com.codegym.furama_management.model.CustomerType;
import com.codegym.furama_management.dto.CustomerDto;
import com.codegym.furama_management.model.User;
import com.codegym.furama_management.service.CustomerService;
import com.codegym.furama_management.service.CustomerTypeService;
import com.codegym.furama_management.service.CustomerUseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @ModelAttribute("user")
    public User setupUser(){
        return new User();
    }

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String showList(@RequestParam(defaultValue = "") String key_name, @RequestParam(defaultValue = "") String key_type,
                           @PageableDefault(size=5) Pageable pageable, Model model){
        Page<Customer> customers = customerService.findAllByNameAndType(key_name, key_type, pageable);
        model.addAttribute("customers", customers);
        model.addAttribute("customerType", customerTypeService.findAll());
        model.addAttribute("key_name", key_name);
        model.addAttribute("key_type", key_type);
        return "customer/list";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerType(new CustomerType());
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "/customer/create";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            customerService.add(customer);
            return "redirect:/customer/list";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id){
        customerService.delete(id);
        return "redirect:/customer/list";
    }


    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto",customerDto);
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "/customer/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "/customer/edit";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            customerService.update(customer);
            return "redirect:/customer/list";
        }
    }

//    @GetMapping("/useService")
//    public String listUseService(Model model){
//        model.addAttribute("customerUserServices",customerUseService.findAllCustomerUseService());
//        return "customer/useService";
//    }
}
