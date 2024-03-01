package com.ucompensar.TechNowAPI.business.service;

import java.util.List;

import com.ucompensar.TechNowAPI.business.dto.RolUpdtDTO;
import com.ucompensar.TechNowAPI.business.entity.RolesEntity;

public interface RolService {

	List<RolesEntity> consultarTodosLosRoles() throws Exception;

	RolesEntity consultarRolXId(Integer id);

	RolesEntity crearRol(String nombreRol);

	RolesEntity modificarRol(RolUpdtDTO rolUpdtDTO);

	Boolean eliminarRol(Integer id);

}
