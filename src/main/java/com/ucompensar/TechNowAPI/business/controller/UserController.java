package com.ucompensar.TechNowAPI.business.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucompensar.TechNowAPI.business.dto.UserCreateDTO;
import com.ucompensar.TechNowAPI.business.dto.UserUpdateDTO;
import com.ucompensar.TechNowAPI.business.entity.UserEntity;
import com.ucompensar.TechNowAPI.business.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/status")
	public Boolean status() {
		return Boolean.TRUE;
	}
	
	@GetMapping("")
	public List<UserEntity> consultarTodosLosUsuarios() {
		try {
			List<UserEntity> lstUsers =  userService.consultarTodosLosUsuarios();
			
			if (lstUsers != null && !lstUsers.isEmpty())
				return lstUsers;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public UserEntity consultarUsuarioXId(@PathVariable Integer id) {
		try {
			UserEntity userEntity =  userService.consultarUsuarioXId(id);
			
			if (userEntity != null && !Objects.isNull(id))
				return userEntity;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("")
	public UserEntity crearUsuario(@RequestBody UserCreateDTO userCreateDTO) {
		try {
			
			UserEntity usuarioCreado = userService.crearUsuario(userCreateDTO);

			if (usuarioCreado != null)
				return usuarioCreado;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("")
    public UserEntity updateUser(@RequestBody UserUpdateDTO UserUpdateDTO) {
        return userService.modificarUsuario(UserUpdateDTO);
    }
	
	@DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable Integer id) {
		try {
			
			if(userService.eliminarUsuario(id))
				return Boolean.TRUE;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return Boolean.FALSE;
    }

}
