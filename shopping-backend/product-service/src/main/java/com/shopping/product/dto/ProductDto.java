package com.shopping.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shopping.product.entity.Brand;
import com.shopping.product.entity.Category;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {
	private Long productId;

	private String productName;

	private String productDescription;

	private Long productPrice;

	private Long discountedPrice;

	private Long stockQuantity;

	private Brand brand;

	private Category category;
}
