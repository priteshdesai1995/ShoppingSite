package com.shopping.carousal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.carousal.dto.CarousalDTO;
import com.shopping.carousal.service.CarousalService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/carousal")
public class CarousalController {

	private final CarousalService carousalService;

	public CarousalController(CarousalService carousalService) {
		this.carousalService = carousalService;
	}

	@PostMapping(path = "/create")
	public CarousalDTO createCarousal(@RequestBody CarousalDTO CarousalDTO) {
		return carousalService.createCarousal(CarousalDTO);
	}

	@GetMapping(path = "/getAll")
	public List<CarousalDTO> getAllCarousal() {
		return carousalService.getAllCarousal();
	}
}
