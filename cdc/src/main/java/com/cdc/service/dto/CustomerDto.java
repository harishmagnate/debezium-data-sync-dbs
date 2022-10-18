package com.cdc.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {

	private Long id;
	private String first_name;
	private String last_name;
	private String email;
}
