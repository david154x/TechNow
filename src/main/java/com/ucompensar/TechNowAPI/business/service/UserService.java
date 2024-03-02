package com.ucompensar.TechNowAPI.business.service;

import java.util.List;

import com.ucompensar.TechNowAPI.business.dto.UserCreateDTO;
import com.ucompensar.TechNowAPI.business.dto.UserUpdDTO;
import com.ucompensar.TechNowAPI.business.entity.UserEntity;

public interface UserService {
	
	List<UserEntity> consultarTodosLosUsuarios() throws Exception;
	
	UserEntity consultarUsuarioXId(Integer id);
	
	UserEntity crearUsuario(UserCreateDTO userCreateDTO);
	
	UserEntity modificarUsuario(UserUpdDTO UserUpdateDTO);
	
	Boolean eliminarUsuario(Integer id);

}
