package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.dto.CustomerUseServiceDto;
import com.codegym.furama_management.model.Customer;
import com.codegym.furama_management.repository.CustomerUseServiceRepository;
import com.codegym.furama_management.service.CustomerUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerUseServiceImpl implements CustomerUseService{
    @Autowired
    private CustomerUseServiceRepository customerUseServiceRepository;

    @Override
    public Page<CustomerUseServiceDto> findAllCustomerUseService(Pageable pageable) {
        return customerUseServiceRepository.findAllCustomerUseService(pageable);
    }
}
