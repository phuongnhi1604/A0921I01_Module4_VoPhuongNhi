package com.codegym.furama_management.repository;

import com.codegym.furama_management.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT * FROM customer where customer_name like concat('%',:customer_name,'%') and customer_type_id like concat('%',:customer_type,'%')",
            nativeQuery = true,
            countQuery = "SELECT count(*) from (SELECT * FROM customer where customer_name like concat('%',:customer_name,'%')  and customer_type_id like concat('%',:customer_type,'%')) abc ")
    Page<Customer> findAllByNameAndType(@Param("customer_name") String customer_name, @Param("customer_type") String customer_type, Pageable pageable);
}
