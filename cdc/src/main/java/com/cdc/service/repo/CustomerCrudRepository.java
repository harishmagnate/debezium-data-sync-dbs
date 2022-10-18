package com.cdc.service.repo;

import org.springframework.data.repository.CrudRepository;

import com.cdc.service.domain.Customer;

public interface CustomerCrudRepository extends CrudRepository<Customer, Long>{

}
