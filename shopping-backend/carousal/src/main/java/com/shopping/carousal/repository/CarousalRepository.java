package com.shopping.carousal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.carousal.entity.CarousalProduct;

@Repository
public interface CarousalRepository extends JpaRepository<CarousalProduct, Long> {

}
