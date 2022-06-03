package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.model.Employee;
import com.codegym.furama_management.repository.EmployeeRepository;
import com.codegym.furama_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Page<Employee> findAllByNameAndPosiAndDivi(String employee_name, String position, String division, Pageable pageable) {
        return employeeRepository.findAllByNameAndPosiAndDivi(employee_name,position,division,pageable);
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null){
            employeeRepository.delete(employee);
        }
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
