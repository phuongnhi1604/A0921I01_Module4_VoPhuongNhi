package com.codegym.furama_management.repository;

import com.codegym.furama_management.dto.CustomerUseServiceDto;
import com.codegym.furama_management.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerUseServiceRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select cus.customer_id,cus.customer_name,cus.customer_id_card,cus.customer_phone,cus.customer_email,atsv.attach_service_name,sv.service_name from customer cus left join contract ct on cus.customer_id=ct.customer_id join service sv on ct.service_id = sv.service_id left join contract_detail ctde on ct.contract_id=ctde.contract_id left join attach_service atsv on ctde.attach_service_id = atsv.attach_service_id", nativeQuery = true)
    public Page<CustomerUseServiceDto> findAllCustomerUseService(Pageable pageable);
}
