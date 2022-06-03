package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.model.ContractDetail;
import com.codegym.furama_management.repository.ContractDetailRepository;
import com.codegym.furama_management.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void add(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
