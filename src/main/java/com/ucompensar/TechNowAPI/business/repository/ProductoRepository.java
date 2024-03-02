package com.ucompensar.TechNowAPI.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucompensar.TechNowAPI.business.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

}
