package com.codegym.furama_management.controller;

import com.codegym.furama_management.model.*;
import com.codegym.furama_management.model.Dto.CustomerDto;
import com.codegym.furama_management.model.Dto.ServiceDto;
import com.codegym.furama_management.service.RentTypeService;
import com.codegym.furama_management.service.ServiceService;
import com.codegym.furama_management.service.ServiceTypeService;
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

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private RentTypeService rentTypeService;

    @Autowired
    private ServiceService service;

    @GetMapping("/list")
    public String showList(@RequestParam(defaultValue = "") String key_service, @RequestParam(defaultValue = "") String key_rent,
                           @PageableDefault(size=5) Pageable pageable, Model model){
        Page<Service> services = service.findAllBySTAndRT(key_service, key_rent, pageable);
        model.addAttribute("services", services);
        model.addAttribute("serviceType", serviceTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        model.addAttribute("key_service", key_service);
        model.addAttribute("key_rent", key_rent);
        return "service/list";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setRentType(new RentType());
        serviceDto.setServiceType(new ServiceType());
        model.addAttribute("serviceDto", serviceDto);
        model.addAttribute("serviceType", serviceTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "service/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ServiceDto serviceDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("serviceDto", serviceDto);
            model.addAttribute("serviceType", serviceTypeService.findAll());
            model.addAttribute("rentType", rentTypeService.findAll());
            return "/service/create";
        }else {
            Service service1 = new Service();
            BeanUtils.copyProperties(serviceDto,service1);
            service.add(service1);
            return "redirect:/service/list";
        }
    }
}
