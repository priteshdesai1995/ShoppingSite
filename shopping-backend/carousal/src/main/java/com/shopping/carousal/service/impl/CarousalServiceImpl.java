package com.shopping.carousal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shopping.carousal.dto.CarousalDTO;
import com.shopping.carousal.entity.CarousalProduct;
import com.shopping.carousal.mapper.CarousalMapper;
import com.shopping.carousal.repository.CarousalRepository;
import com.shopping.carousal.service.CarousalService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarousalServiceImpl implements CarousalService {

	CarousalRepository carousalRepository;

	@Override
	public CarousalDTO createCarousal(CarousalDTO CarousalDTO) {
		// TODO Auto-generated method stub
		CarousalProduct carousalProduct = carousalRepository.save(CarousalMapper.mapToEntity(CarousalDTO));
		return CarousalMapper.mapToDTO(carousalProduct);
	}

	@Override
	public List<CarousalDTO> getAllCarousal() {
		List<CarousalProduct> carousalProductList = carousalRepository.findAll();
		List<CarousalDTO> dtoListIs = carousalProductList.stream().map((product) -> CarousalMapper.mapToDTO(product)).collect(Collectors.toList());
		return dtoListIs;
	}

}
