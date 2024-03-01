package com.ucompensar.TechNowAPI.business.service;

import java.util.List;

import com.ucompensar.TechNowAPI.business.dto.MenuRolDTO;
import com.ucompensar.TechNowAPI.business.dto.MenuRolesUpdDTO;
import com.ucompensar.TechNowAPI.business.entity.MenuEntity;

public interface MenuService {
	
	List<MenuEntity> consultarTodosLosMenu() throws Exception;
	
	MenuEntity consultarMenuXId(Integer id);
	
	MenuEntity crearMenu(MenuRolDTO menuRolDTO);
	
	MenuEntity modificarMenu(MenuRolesUpdDTO menuRolesUpdDTO);
	
	Boolean eliminarMenu(Integer id);

}
