package com.ucompensar.TechNowAPI.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucompensar.TechNowAPI.business.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
