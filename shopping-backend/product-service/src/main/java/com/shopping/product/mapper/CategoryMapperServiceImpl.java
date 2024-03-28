package com.shopping.product.mapper;

import org.springframework.stereotype.Service;

import com.shopping.product.dto.CategoryDto;
import com.shopping.product.entity.Category;

@Service
public class CategoryMapperServiceImpl implements CategoryMapperService {

	@Override
	public Category categoryDtoToCategory(CategoryDto categoryDto) {
		Category category = new Category();
		category.setCategoryName(categoryDto.getCategoryName());

		if (categoryDto.getParentCategory() != null)
			category.setParentCategory(categoryDto.getParentCategory());
		return category;
	}

}
