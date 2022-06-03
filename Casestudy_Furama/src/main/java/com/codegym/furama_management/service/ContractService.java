package com.codegym.furama_management.service;

import com.codegym.furama_management.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    public Page<Contract> findAllByNativeQuery(Pageable pageable);
    public void add(Contract contract);
    public List<Contract> findAll();
}
