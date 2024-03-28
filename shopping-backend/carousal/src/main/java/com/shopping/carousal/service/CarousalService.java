package com.shopping.carousal.service;

import java.util.List;

import com.shopping.carousal.dto.CarousalDTO;

public interface CarousalService {

	public CarousalDTO createCarousal(CarousalDTO CarousalDTO);

	public List<CarousalDTO> getAllCarousal();
}
