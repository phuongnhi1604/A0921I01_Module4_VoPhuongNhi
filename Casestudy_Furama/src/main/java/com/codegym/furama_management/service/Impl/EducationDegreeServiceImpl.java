package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.model.EducationDegree;
import com.codegym.furama_management.repository.EducationDegreeRepository;
import com.codegym.furama_management.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
