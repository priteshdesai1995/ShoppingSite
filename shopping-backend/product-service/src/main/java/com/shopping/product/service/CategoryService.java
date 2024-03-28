package com.shopping.product.service;

import java.util.Optional;

import com.shopping.product.dto.CategoryDto;
import com.shopping.product.entity.Category;

public interface CategoryService {
	Optional<Category> createCategory(CategoryDto category);
}
