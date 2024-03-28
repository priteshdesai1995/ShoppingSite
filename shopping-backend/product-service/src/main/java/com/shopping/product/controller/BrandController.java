package com.shopping.product.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.product.dto.BrandDto;
import com.shopping.product.entity.Brand;
import com.shopping.product.service.BrandService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/brand")
public class BrandController {

	BrandService brandService;

	@PostMapping
	public Brand createBrand(@RequestBody BrandDto brandDto) {
		Optional<Brand> brand = brandService.createBrand(brandDto);
		return brand.get();
	}
}
