package com.shopping.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shopping.product.entity.Category;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDto {
	private long categoryId;
	private String categoryName;
	private Category parentCategory;
}
