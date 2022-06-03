package com.codegym.furama_management.repository;

import com.codegym.furama_management.model.Employee;
import com.codegym.furama_management.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
    @Query(value = "SELECT * FROM service where service_type_id like concat('%',:service_type_id,'%') and rent_type_id like concat('%',:rent_type_id,'%')",
            nativeQuery = true,
            countQuery = "SELECT count(*) from (SELECT * FROM service where service_type_id like concat('%',:service_type_id,'%') and rent_type_id like concat('%',:rent_type_id,'%')) def ")
    Page<Service> findAllBySTAndRT(@Param("service_type_id") String service_type, @Param("rent_type_id") String rent_type, Pageable pageable);
}
