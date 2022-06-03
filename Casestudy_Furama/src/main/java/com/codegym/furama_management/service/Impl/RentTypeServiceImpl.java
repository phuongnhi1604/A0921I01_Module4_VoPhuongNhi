package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.model.RentType;
import com.codegym.furama_management.repository.RentTypeRepository;
import com.codegym.furama_management.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
