package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.model.Role;
import com.codegym.furama_management.repository.RoleRepository;
import com.codegym.furama_management.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
