package com.ucompensar.TechNowAPI.business.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucompensar.TechNowAPI.business.dto.RolUpdtDTO;
import com.ucompensar.TechNowAPI.business.entity.RolesEntity;
import com.ucompensar.TechNowAPI.business.repository.RolesRepository;
import com.ucompensar.TechNowAPI.business.service.RolService;

@Service
public class RolServiceImpl implements RolService {
	
	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public List<RolesEntity> consultarTodosLosRoles() throws Exception {
		try {
			List<RolesEntity> lstRoles =  rolesRepository.findAll();
			
			if (lstRoles != null && !lstRoles.isEmpty())
				return lstRoles;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RolesEntity consultarRolXId(Integer id) {
		try {
			
			Optional<RolesEntity> rolesEntity = rolesRepository.findById(id);
			
			if (rolesEntity != null && !Objects.isNull(rolesEntity))
				return rolesEntity.get();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RolesEntity crearRol(String nombreRol) {
		try {
			RolesEntity RolesCreate = rolesRepository.save(RolesEntity.builder()
													 .nombreRol(nombreRol)
													 .fechaCreacion(new Date())
													 .idActivo("A")
													 .build());
			
			if(RolesCreate != null && !Objects.isNull(RolesCreate))
				return RolesCreate;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RolesEntity modificarRol(RolUpdtDTO rolUpdtDTO) {
		try {
			
			Optional<RolesEntity> rolesEntity = rolesRepository.findById(rolUpdtDTO.getIdRol());
			
			if (rolesEntity != null && !Objects.isNull(rolesEntity)) {
				rolesEntity.get().setNombreRol(rolUpdtDTO.getNombreRol());
				rolesEntity.get().setIdActivo(rolUpdtDTO.getIdActivo());

				RolesEntity rolesUpdate = rolesRepository.save(rolesEntity.get());

				if (rolesUpdate != null && !Objects.isNull(rolesUpdate))
					return rolesUpdate;
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean eliminarRol(Integer id) {
		try {
			
			rolesRepository.deleteById(id);
			return Boolean.TRUE;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}

}
