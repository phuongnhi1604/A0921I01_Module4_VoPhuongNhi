package com.codegym.form_dang_ky.service.impl;

import com.codegym.form_dang_ky.model.User;
import com.codegym.form_dang_ky.repository.UserRepository;
import com.codegym.form_dang_ky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void add(User user) {
        userRepository.save(user);
    }
}
