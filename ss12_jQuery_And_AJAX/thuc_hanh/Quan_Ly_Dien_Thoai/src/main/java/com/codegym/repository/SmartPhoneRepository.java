package com.codegym.repository;

import com.codegym.model.SmartPhone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartPhoneRepository extends CrudRepository<SmartPhone, Long> {
}
