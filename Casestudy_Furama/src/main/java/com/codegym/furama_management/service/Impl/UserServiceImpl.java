package com.codegym.furama_management.service.Impl;

import com.codegym.furama_management.model.User;
import com.codegym.furama_management.repository.UserRepository;
import com.codegym.furama_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
