package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.model.Contract;
import com.codegym.furama_management.repository.ContractRepository;
import com.codegym.furama_management.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Page<Contract> findAllByNativeQuery(Pageable pageable) {
        return contractRepository.findAllByNativeQuery(pageable);
    }

    @Override
    public void add(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
}
