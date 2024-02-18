package com.ucompensar.TechNowAPI.business.service;

import java.util.List;

import com.ucompensar.TechNowAPI.business.dto.UserCreateDTO;
import com.ucompensar.TechNowAPI.business.dto.UserUpdateDTO;
import com.ucompensar.TechNowAPI.business.entity.UserEntity;

public interface UserService {
	
	List<UserEntity> consultarTodosLosUsuarios() throws Exception;
	
	UserEntity consultarUsuarioXId(Integer id);
	
	UserEntity crearUsuario(UserCreateDTO userCreateDTO);
	
	UserEntity modificarUsuario(UserUpdateDTO UserUpdateDTO);
	
	Boolean eliminarUsuario(Integer id);

}
