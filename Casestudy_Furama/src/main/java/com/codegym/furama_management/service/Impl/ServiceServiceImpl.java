package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.repository.ServiceRepository;
import com.codegym.furama_management.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public Page<com.codegym.furama_management.model.Service> findAllBySTAndRT(String serviceType, String rentType, Pageable pageable) {
        return serviceRepository.findAllBySTAndRT(serviceType,rentType,pageable);
    }

    @Override
    public void add(com.codegym.furama_management.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public List<com.codegym.furama_management.model.Service> findAll() {
        return serviceRepository.findAll();
    }
}
