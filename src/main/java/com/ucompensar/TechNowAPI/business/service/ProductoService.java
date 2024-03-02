package com.ucompensar.TechNowAPI.business.service;

import java.util.List;

import com.ucompensar.TechNowAPI.business.dto.ProductoCreateDTO;
import com.ucompensar.TechNowAPI.business.dto.ProductoUpdDTO;
import com.ucompensar.TechNowAPI.business.entity.ProductoEntity;

public interface ProductoService {
	
	List<ProductoEntity> consultarTodosLosProductos() throws Exception;

	ProductoEntity consultarProductoXId(Integer id);

	ProductoEntity crearProducto(ProductoCreateDTO productoCreateDTO);

	ProductoEntity modificarProducto(ProductoUpdDTO productoUpdDTO);

	Boolean eliminarProducto(Integer id);

}
