package com.ucompensar.TechNowAPI.business.service;

import java.util.List;

import com.ucompensar.TechNowAPI.business.dto.UserRolCreateDTO;
import com.ucompensar.TechNowAPI.business.dto.UserRolUpdateDTO;
import com.ucompensar.TechNowAPI.business.entity.UserRolEntity;

public interface UserRolService {
	
	 List<UserRolEntity> consultarTodosLosRolesUsuario() throws Exception;

	 UserRolEntity consultarRolUsuarioXId(Integer id);

	 List<UserRolEntity> crearRolUsuario(UserRolCreateDTO userRolCreateDTO);

	 UserRolEntity modificarRolUsuario(UserRolUpdateDTO userRolUpdateDTO);

	 Boolean eliminarRolUsuario(Integer id);

}
