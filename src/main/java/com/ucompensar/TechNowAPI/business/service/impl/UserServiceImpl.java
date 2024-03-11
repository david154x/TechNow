package com.ucompensar.TechNowAPI.business.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucompensar.TechNowAPI.business.dto.UserCreateDTO;
import com.ucompensar.TechNowAPI.business.dto.UserUpdDTO;
import com.ucompensar.TechNowAPI.business.entity.PersonaEntity;
import com.ucompensar.TechNowAPI.business.entity.UserEntity;
import com.ucompensar.TechNowAPI.business.repository.PersonaRepository;
import com.ucompensar.TechNowAPI.business.repository.UserRepository;
import com.ucompensar.TechNowAPI.business.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PersonaRepository personaRepository; 

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
			PersonaEntity personaCreada = personaRepository.save(PersonaEntity.builder()
                                                                              .numeroDocumento(userCreateDTO.getNumeroDocumento())
                                                                              .primerNombre(userCreateDTO.getPrimerNombre())
                                                                              .segundoNombre(userCreateDTO.getSegundoNombre())
                                                                              .primerApellido(userCreateDTO.getPrimerApellido())
                                                                              .segundoApellido(userCreateDTO.getSegundoApellido())
                                                                              .genero(userCreateDTO.getGenero())
                                                                              .fechaNacimiento(userCreateDTO.getFechaNacimiento())
                                                                              .telefono(userCreateDTO.getTelefono())
                                                                              .fechaCreacion(new Date())
                                                                              .build());
			
			
			UserEntity usuarioCreado = userRepository.save(UserEntity.builder()
					                                                 .nombreUsuario(userCreateDTO.getNuevoUsuario())
					                                                 .contraseniaUsuario(userCreateDTO.getNuevaContrasena())
					                                                 .personaEntity(personaCreada)
					                                                 .idActivo("A")
					                                                 .fechaCreacion(new Date())
					                                                 .build());

			if (usuarioCreado != null && !Objects.isNull(usuarioCreado))
				return usuarioCreado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserEntity modificarUsuario(UserUpdDTO UserUpdateDTO) {
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
	
	@Override
	public UserEntity verificarPassword(String nombreUsuario, String contrasenia) {
	    try {
	        UserEntity usuario = userRepository.findByNombreUsuario(nombreUsuario);
	        if (usuario != null && usuario.getContraseniaUsuario().equals(contrasenia)) {
	            return usuario;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}



}
