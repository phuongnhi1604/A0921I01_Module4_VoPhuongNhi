package com.codegym.furama_management.service;

import com.codegym.furama_management.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    public Page<Service> findAllBySTAndRT(String serviceType, String rentType, Pageable pageable);
    public void add(Service service);
    public List<Service> findAll();
}
