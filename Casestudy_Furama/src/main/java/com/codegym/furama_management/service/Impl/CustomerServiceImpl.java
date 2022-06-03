package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.model.Customer;
import com.codegym.furama_management.repository.CustomerRepository;
import com.codegym.furama_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Page<Customer> findAllByNameAndType(String name, String type, Pageable pageable) {
        return customerRepository.findAllByNameAndType(name, type, pageable);
    }

    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer!=null){
            customerRepository.delete(customer);
        }
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
