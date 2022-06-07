package com.codegym.furama_management.controller;

import com.codegym.furama_management.model.*;
import com.codegym.furama_management.dto.EmployeeDto;
import com.codegym.furama_management.service.DivisionService;
import com.codegym.furama_management.service.EducationDegreeService;
import com.codegym.furama_management.service.EmployeeService;
import com.codegym.furama_management.service.PositionService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private PositionService positionService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String showList(@RequestParam(defaultValue = "") String key_name, @RequestParam(defaultValue = "") String key_position,
                           @RequestParam(defaultValue = "") String key_division,
                           @PageableDefault(size=5) Pageable pageable, Model model){
        Page<Employee> employees = employeeService.findAllByNameAndPosiAndDivi(key_name, key_position,key_division, pageable);
        model.addAttribute("employees", employees);
        model.addAttribute("position", positionService.findAll());
        model.addAttribute("division", divisionService.findAll());
        model.addAttribute("educationDegree", educationDegreeService.findAll());
        model.addAttribute("key_name", key_name);
        model.addAttribute("key_position", key_position);
        model.addAttribute("key_division", key_division);
        return "employee/list";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setPosition(new Position());
        employeeDto.setDivision(new Division());
        employeeDto.setEducationDegree(new EducationDegree());
        employeeDto.setUser(new User());
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("position", positionService.findAll());
        model.addAttribute("division", divisionService.findAll());
        model.addAttribute("degree", educationDegreeService.findAll());
        return "employee/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("employeeDto", employeeDto);
            model.addAttribute("position", positionService.findAll());
            model.addAttribute("division", divisionService.findAll());
            model.addAttribute("degree", educationDegreeService.findAll());
            return "employee/create";
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            employeeService.add(employee);
            return "redirect:/employee/list";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id){
        employeeService.delete(id);
        return "redirect:/employee/list";
    }


    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto",employeeDto);
        model.addAttribute("position", positionService.findAll());
        model.addAttribute("division", divisionService.findAll());
        model.addAttribute("degree", educationDegreeService.findAll());
        return "/employee/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("employeeDto", employeeDto);
            model.addAttribute("position", positionService.findAll());
            model.addAttribute("division", divisionService.findAll());
            model.addAttribute("degree", educationDegreeService.findAll());
            return "/employee/edit";
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            employeeService.update(employee);
            return "redirect:/employee/list";
        }
    }
}
