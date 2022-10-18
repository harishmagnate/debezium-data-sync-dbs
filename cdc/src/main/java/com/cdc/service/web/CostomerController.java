package com.cdc.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdc.service.domain.Customer;
import com.cdc.service.repo.CustomerRepo;

@RestController("customers")
public class CostomerController {

	@Autowired
	private CustomerRepo customerRepo;

	@GetMapping
	@ResponseBody
	public List<Customer> getCustomersbyLastName() {
		return customerRepo.findAll();
	}

}
