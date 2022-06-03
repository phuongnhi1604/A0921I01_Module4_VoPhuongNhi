package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.model.UserRole;
import com.codegym.furama_management.repository.UserRoleRepository;
import com.codegym.furama_management.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }
}
