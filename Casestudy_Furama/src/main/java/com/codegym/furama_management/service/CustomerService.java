package com.codegym.furama_management.service;

import com.codegym.furama_management.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    public Page<Customer> findAllByNameAndType(String name, String type, Pageable pageable);
    public void add(Customer customer);
    public void delete(int id);
    public void update(Customer customer);
    public Customer findById(int id);
    public List<Customer> findAll();

}
