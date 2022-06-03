package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.model.CustomerType;
import com.codegym.furama_management.repository.CustomerTypeRepository;
import com.codegym.furama_management.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
