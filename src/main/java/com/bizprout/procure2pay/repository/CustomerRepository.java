package com.bizprout.procure2pay.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bizprout.procure2pay.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}