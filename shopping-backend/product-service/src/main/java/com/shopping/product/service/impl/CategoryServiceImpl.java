package com.shopping.product.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.product.dto.CategoryDto;
import com.shopping.product.entity.Category;
import com.shopping.product.mapper.CategoryMapperService;
import com.shopping.product.repository.CategoryRepository;
import com.shopping.product.service.CategoryService;

import lombok.AllArgsConstructor;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	Logger Log = LoggerFactory.getLogger(getClass());

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryMapperService categoryMapperService;

	@Override
	public Optional<Category> createCategory(CategoryDto category) {
		Log.info("CategoryDto is in Service : " + category.toString());
		Category cat = categoryMapperService.categoryDtoToCategory(category);
		Log.info("Category is in Service : " + cat.toString());

		return Optional.of(categoryRepository.save(cat));
	}

}
