package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.repository.AttachServiceRepository;
import com.codegym.furama_management.service.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements AttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;
    @Override
    public List<com.codegym.furama_management.model.AttachService> findALl() {
        return attachServiceRepository.findAll();
    }
}
