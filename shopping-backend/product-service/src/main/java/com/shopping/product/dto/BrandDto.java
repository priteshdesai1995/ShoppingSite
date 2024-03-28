package com.shopping.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandDto {
	
	private String brandName;
	
	private String description;
}
