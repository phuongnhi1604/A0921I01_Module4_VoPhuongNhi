package com.codegym.furama_management.controller;

import com.codegym.furama_management.model.Contract;
import com.codegym.furama_management.model.Customer;
import com.codegym.furama_management.model.Dto.ContractDto;
import com.codegym.furama_management.model.Dto.CustomerDto;
import com.codegym.furama_management.model.Employee;
import com.codegym.furama_management.model.Service;
import com.codegym.furama_management.service.ContractService;
import com.codegym.furama_management.service.CustomerService;
import com.codegym.furama_management.service.EmployeeService;
import com.codegym.furama_management.service.ServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ContractService contractService;

    @GetMapping("/list")
    public String list(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<Contract> contracts = contractService.findAllByNativeQuery(pageable);
        model.addAttribute("contracts", contracts);
        return "contract/list";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        ContractDto contractDto = new ContractDto();
        contractDto.setCustomer(new Customer());
        contractDto.setEmployee(new Employee());
        contractDto.setService(new Service());
        model.addAttribute("contractDto", contractDto);
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("services", serviceService.findAll());
        return "contract/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ContractDto contractDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("contractDto", contractDto);
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("services", serviceService.findAll());
            return "/contract/create";
        }else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            contractService.add(contract);
            return "redirect:/contract/list";
        }
    }
}
