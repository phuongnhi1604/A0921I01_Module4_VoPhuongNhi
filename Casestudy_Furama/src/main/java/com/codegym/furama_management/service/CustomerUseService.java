package com.codegym.furama_management.service;

import com.codegym.furama_management.dto.CustomerUseServiceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CustomerUseService {
    public Page<CustomerUseServiceDto> findAllCustomerUseService(Pageable pageable);
}
