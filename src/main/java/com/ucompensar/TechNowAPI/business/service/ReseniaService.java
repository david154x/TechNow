package com.ucompensar.TechNowAPI.business.service;

import java.util.List;

import com.ucompensar.TechNowAPI.business.dto.ReseniaCreateDTO;
import com.ucompensar.TechNowAPI.business.dto.ReseniaUpdDTO;
import com.ucompensar.TechNowAPI.business.entity.ReseniaEntity;

public interface ReseniaService {
	
	List<ReseniaEntity> buscarTodasLasResenias();
	
	ReseniaEntity buscarReseniaXId(Integer idResenia);
	
	ReseniaEntity guardarResenia(ReseniaCreateDTO reseniaCreateDTO);
	
	ReseniaEntity actualizarResenia(ReseniaUpdDTO reseniaUpdDTO);
	
	Boolean eliminarResenia(Integer idResenia);

}
