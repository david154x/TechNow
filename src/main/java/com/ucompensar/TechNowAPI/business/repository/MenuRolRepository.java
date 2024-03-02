package com.ucompensar.TechNowAPI.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucompensar.TechNowAPI.business.entity.MenuEntity;

public interface MenuRolRepository extends JpaRepository<MenuEntity, Integer> {

}
