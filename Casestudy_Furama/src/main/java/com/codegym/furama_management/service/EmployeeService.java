package com.codegym.furama_management.service;

import com.codegym.furama_management.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface EmployeeService {
    public Page<Employee> findAllByNameAndPosiAndDivi(String employee_name, String position, String division, Pageable pageable);
    public void add(Employee employee);
    public void delete(int id);
    public void update(Employee employee);
    public Employee findById(int id);
    public List<Employee> findAll();
}
