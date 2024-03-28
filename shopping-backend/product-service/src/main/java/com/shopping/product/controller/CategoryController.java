package com.shopping.product.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.product.dto.CategoryDto;
import com.shopping.product.entity.Category;
import com.shopping.product.service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	Logger Log = LoggerFactory.getLogger(getClass());

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public Category createCategory(@RequestBody CategoryDto categoryDto) {
		Log.info("categoryDto is : " + categoryDto.toString());
		Optional<Category> category = categoryService.createCategory(categoryDto);
		return category.get();
	}
}
