package com.ucompensar.TechNowAPI.business.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucompensar.TechNowAPI.business.dto.UserCreateDTO;
import com.ucompensar.TechNowAPI.business.dto.UserUpdateDTO;
import com.ucompensar.TechNowAPI.business.entity.UserEntity;
import com.ucompensar.TechNowAPI.business.repository.UserRepository;
import com.ucompensar.TechNowAPI.business.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserEntity> consultarTodosLosUsuarios() throws Exception {
		try {
			
			List<UserEntity> lstUsers = userRepository.findAll();
			
			if(lstUsers == null || lstUsers.isEmpty())
				throw new Exception("No se encontraron usuarios");
			
			return lstUsers;
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public UserEntity consultarUsuarioXId(Integer id) {
		try {
			Optional<UserEntity> optUsuarioEncontrado = userRepository.findById(id);
			
			if(!optUsuarioEncontrado.isPresent())
				throw new Exception("No se encontro el usuario con la id: "+id+" enviado.");
			
			return optUsuarioEncontrado.get();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public UserEntity crearUsuario(UserCreateDTO userCreateDTO) {
		try {
			UserEntity usuarioCreado = userRepository.save(UserEntity.builder()
					  												 .nombreUsuario(userCreateDTO.getNombreUsuario())
					  												 .contraseniaUsuario(userCreateDTO.getClaveUsuario())
					  												 .fechaCreacion(new Date())
					  												 .idActivo("A")
					  												 .build());

			if (usuarioCreado != null && !Objects.isNull(usuarioCreado))
				return usuarioCreado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserEntity modificarUsuario(UserUpdateDTO UserUpdateDTO) {
		try {
			UserEntity usuarioEncontrado = consultarUsuarioXId(UserUpdateDTO.getId());
			
			if(usuarioEncontrado == null && Objects.isNull(usuarioEncontrado))
				throw new Exception("No se encontro el usuario con la id: " + UserUpdateDTO.getId() + " enviado, no se puede modificar el usuario.");
			
			usuarioEncontrado.setNombreUsuario(UserUpdateDTO.getNombreUsuario());
			usuarioEncontrado.setContraseniaUsuario(UserUpdateDTO.getClaveUsuario());
			usuarioEncontrado.setIdActivo(UserUpdateDTO.getIdActivo());
			
			UserEntity usuarioModificado = userRepository.save(usuarioEncontrado);
			
			if(usuarioModificado == null && Objects.isNull(usuarioModificado))
				throw new Exception("No se pudo modificar el usuario.");
			
			return usuarioModificado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean eliminarUsuario(Integer id) {
		try {
			userRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}

}
