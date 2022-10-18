package com.cdc.service.streams;

import com.cdc.service.domain.Customer;
import com.cdc.service.dto.CustomerDto;
import com.cdc.service.dto.CustomerMessage;
import com.cdc.service.repo.CustomerCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CdcKafkaConsumer {

	@Autowired
	private CustomerCrudRepository customerRepo;

	@KafkaListener(topics = "server1.dbo.customers")
	public void processCustomerMessage(@Payload(required = false) String content)
			throws JsonMappingException, JsonProcessingException {
		System.out.println("Message received: " + content);

		ObjectMapper mapper = new ObjectMapper();
		if (content == null)
			return;
		CustomerMessage msg = mapper.readValue(content, CustomerMessage.class);
		if (msg == null || msg.getPayload() == null)
			return;
		CustomerDto customerDto = msg.getPayload().getAfter();
		if (customerDto == null) {
			CustomerDto customerDtoBefore = msg.getPayload().getBefore();
			if (customerDtoBefore != null) {
				customerRepo.deleteById(customerDtoBefore.getId());
			}
		} else {
			Customer customer = new Customer();
			customer.setId(customerDto.getId());
			customer.setEmail(customerDto.getEmail());
			customer.setFirstName(customerDto.getFirst_name());
			customer.setLastName(customerDto.getLast_name());
			customerRepo.save(customer);
		}
	}
}
