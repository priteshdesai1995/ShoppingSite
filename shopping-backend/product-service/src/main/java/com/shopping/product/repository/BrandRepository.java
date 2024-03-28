package com.shopping.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.product.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
