package com.codegym.service;

import com.codegym.model.SmartPhone;

import java.util.Optional;

public interface SmartPhoneService {
    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);
    public SmartPhone findByID(Long id);
    SmartPhone save(SmartPhone smartPhone);
    void update(SmartPhone smartPhone);
    void remove(Long id);
}
