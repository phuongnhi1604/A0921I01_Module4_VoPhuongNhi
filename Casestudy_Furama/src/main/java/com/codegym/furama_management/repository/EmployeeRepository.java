package com.codegym.furama_management.repository;

import com.codegym.furama_management.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM employee where employee_name like concat('%',:employee_name,'%') and position_id like concat('%',:position_id,'%')" +
            "and division_id like concat('%',:division_id,'%')",
            nativeQuery = true,
            countQuery = "SELECT count(*) from (SELECT * FROM employee where employee_name like concat('%',:employee_name,'%') and position_id like concat('%',:position_id,'%') and division_id like concat('%',:division_id,'%')) xyz ")
    Page<Employee> findAllByNameAndPosiAndDivi(@Param("employee_name") String employee_name, @Param("position_id") String position,@Param("division_id") String division , Pageable pageable);
}
