package com.codegym.furama_management.controller;

import com.codegym.furama_management.model.*;
import com.codegym.furama_management.dto.ContractDetailDto;
import com.codegym.furama_management.service.AttachServiceService;
import com.codegym.furama_management.service.ContractDetailService;
import com.codegym.furama_management.service.ContractService;
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
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private AttachServiceService attachServiceService;

    @Autowired
    private ContractService contractService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("contractDetails",contractDetailService.findAll());
        return "contract_detail/list";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        contractDetailDto.setContract(new Contract());
        contractDetailDto.setAttachService(new AttachService());
        model.addAttribute("contractDetailDto", contractDetailDto);
        model.addAttribute("contracts", contractService.findAll());
        model.addAttribute("attachServices", attachServiceService.findALl());
        return "contract_detail/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ContractDetailDto contractDetailDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("contractDetailDto", contractDetailDto);
            model.addAttribute("contracts", contractService.findAll());
            model.addAttribute("attachServices", attachServiceService.findALl());
            return "/contract_detail/create";
        }else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto,contractDetail);
            contractDetailService.add(contractDetail);
            return "redirect:/contractDetail/list";
        }
    }
}
