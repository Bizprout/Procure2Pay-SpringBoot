package com.bizprout.procure2pay.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bizprout.procure2pay.entity.Client;


public interface ClientRepository extends CrudRepository<Client, Long> {

    
}