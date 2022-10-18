package com.cdc.service.repo;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.cdc.service.domain.Customer;

public interface CustomerRepo extends Repository<Customer, Long> {

	public List<Customer> findByLastName(String lastName);
	
	public List<Customer> findAll();

}
