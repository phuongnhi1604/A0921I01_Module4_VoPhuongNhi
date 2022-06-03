package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.model.Division;
import com.codegym.furama_management.repository.DivisionRepository;
import com.codegym.furama_management.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
