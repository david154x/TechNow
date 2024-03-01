package com.ucompensar.TechNowAPI.business.service;

import java.util.List;

import com.ucompensar.TechNowAPI.business.dto.MarcaUpdateDTO;
import com.ucompensar.TechNowAPI.business.entity.MarcaEntity;

public interface MarcaService {
	
	List<MarcaEntity> consultarTodasLasMarcas() throws Exception;
	
	MarcaEntity consultarMarcaXId(Integer id);
	
	MarcaEntity crearMarca(String nombreMarca);
	
	MarcaEntity modificarMarca(MarcaUpdateDTO marcaUpdateDTO);
	
	Boolean eliminarMarca(Integer id);

}
