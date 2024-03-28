package com.shopping.product.service;

import java.util.Optional;

import com.shopping.product.dto.BrandDto;
import com.shopping.product.entity.Brand;

public interface BrandService {
	Optional<Brand> createBrand(BrandDto brand);
}
