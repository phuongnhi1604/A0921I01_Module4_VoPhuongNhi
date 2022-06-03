package com.codegym.furama_management.repository;

import com.codegym.furama_management.model.Contract;
import com.codegym.furama_management.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

@Controller
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "SELECT * FROM contract", nativeQuery = true,
            countQuery = "SELECT count(*) from (SELECT * FROM contract) abc ")
    Page<Contract> findAllByNativeQuery(Pageable pageable);
}
