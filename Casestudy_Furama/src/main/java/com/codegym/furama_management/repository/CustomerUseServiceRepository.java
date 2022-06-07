package com.codegym.furama_management.repository;

import com.codegym.furama_management.dto.CustomerUseServiceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerUseServiceRepository extends JpaRepository<CustomerUseServiceDto, Integer> {
    @Query(value = "call get_all_customer_use_service()", nativeQuery = true)
    public List<CustomerUseServiceDto> findAll();
}
