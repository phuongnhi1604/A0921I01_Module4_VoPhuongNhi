package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.model.ServiceType;
import com.codegym.furama_management.repository.ServiceTypeRepository;
import com.codegym.furama_management.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
