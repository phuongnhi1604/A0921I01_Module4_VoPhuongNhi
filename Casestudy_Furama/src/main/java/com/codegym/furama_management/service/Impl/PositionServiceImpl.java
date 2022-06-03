package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.model.Position;
import com.codegym.furama_management.repository.PositionRepository;
import com.codegym.furama_management.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
