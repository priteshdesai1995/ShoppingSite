package com.shopping.product.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.product.dto.BrandDto;
import com.shopping.product.entity.Brand;
import com.shopping.product.mapper.BrandMapperService;
import com.shopping.product.repository.BrandRepository;
import com.shopping.product.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	Logger Log = LoggerFactory.getLogger(getClass());

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private BrandMapperService brandMapperService;

	@Override
	public Optional<Brand> createBrand(BrandDto brand) {
		// TODO Auto-generated method stub
		Brand brandEntity = brandMapperService.brandDtoToBrand(brand);
		Log.info("brandEntity : " + brandEntity.toString());
		Brand newBrand = brandRepository.save(brandEntity);
		Log.info("newBrand : " + newBrand.toString());
		return Optional.of(newBrand);
	}

}
