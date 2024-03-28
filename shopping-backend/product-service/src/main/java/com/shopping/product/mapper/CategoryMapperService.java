package com.shopping.product.mapper;

import com.shopping.product.dto.CategoryDto;
import com.shopping.product.entity.Category;


public interface CategoryMapperService {
	Category categoryDtoToCategory(CategoryDto categoryDto);
}
