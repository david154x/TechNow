package com.ucompensar.TechNowAPI.business.service;

import java.util.List;

import com.ucompensar.TechNowAPI.business.dto.TipoProductoUpdDTO;
import com.ucompensar.TechNowAPI.business.entity.TipoProductoEntity;

public interface TipoProductoService {
	
	List<TipoProductoEntity> consultarTodosLosTipoProductos() throws Exception;
	
	TipoProductoEntity consultarTipoProductoXId(Integer id);
	
	TipoProductoEntity crearTipoProducto(String nombreTipoProducto);
	
	TipoProductoEntity modificarTipoProducto(TipoProductoUpdDTO tipoProductoUpdDTO);
	
	Boolean eliminarTipoProducto(Integer id);

}
