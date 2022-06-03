package com.codegym.furama_management.service;

import com.codegym.furama_management.model.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    public List<ContractDetail> findAll();
    public void add(ContractDetail contractDetail);
}
