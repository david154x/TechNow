package com.ucompensar.TechNowAPI.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucompensar.TechNowAPI.business.entity.PersonaEntity;

public interface PersonaRepository extends JpaRepository<PersonaEntity, String>  {

}
