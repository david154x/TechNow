package com.ucompensar.TechNowAPI.business.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucompensar.TechNowAPI.business.dto.MenuRolDTO;
import com.ucompensar.TechNowAPI.business.dto.MenuRolesUpdDTO;
import com.ucompensar.TechNowAPI.business.entity.MenuEntity;
import com.ucompensar.TechNowAPI.business.entity.RolesEntity;
import com.ucompensar.TechNowAPI.business.repository.MenuRolRepository;
import com.ucompensar.TechNowAPI.business.repository.RolesRepository;
import com.ucompensar.TechNowAPI.business.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuRolRepository menuRolRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	

	@Override
	public List<MenuEntity> consultarTodosLosMenu() throws Exception {
		try {
			List<MenuEntity> lstMenus =  menuRolRepository.findAll();
			
			if (lstMenus != null && !lstMenus.isEmpty())
				return lstMenus;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MenuEntity consultarMenuXId(Integer id) {
		try {
            Optional<MenuEntity> optMenuEntity = menuRolRepository.findById(id);
            
            if(optMenuEntity.isPresent())
            	return optMenuEntity.get();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MenuEntity crearMenu(MenuRolDTO menuRolDTO) {
		MenuEntity menuCreado = null;
		try {
			List<RolesEntity> roles = rolesRepository.findAllById(menuRolDTO.getLstIdRoles());
			
			menuCreado = menuRolRepository.save(MenuEntity.builder()
										  .nombre(menuRolDTO.getNombreMenu())
										  .rutaURL(menuRolDTO.getRutaURL())
										  .rolesEntity(roles)
										  .idActivo("A")
										  .fechaCreacion(new Date())
										  .build());
			
			if(menuCreado != null )
				return menuCreado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MenuEntity modificarMenu(MenuRolesUpdDTO menuRolesUpdDTO) {
		try {
			List<RolesEntity> roles = rolesRepository.findAllById(menuRolesUpdDTO.getLstIdRoles());
			
			Optional<MenuEntity> optMenuEntiy = menuRolRepository.findById(menuRolesUpdDTO.getIdMenu());
			
			optMenuEntiy.get().setNombre(menuRolesUpdDTO.getNuevoNombreMenu());
			optMenuEntiy.get().setRolesEntity(roles);
			optMenuEntiy.get().setIdActivo(menuRolesUpdDTO.getIdActivo());
			
			MenuEntity menuModificado = menuRolRepository.save(optMenuEntiy.get());
			
			if (menuModificado != null)
				return menuModificado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean eliminarMenu(Integer id) {
		try {
			menuRolRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}

}
