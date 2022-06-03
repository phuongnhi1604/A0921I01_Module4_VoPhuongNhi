package com.codegym.furama_management.repository;

import com.codegym.furama_management.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
