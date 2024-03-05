package com.ucompensar.TechNowAPI.business.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRolCreateDTO {
	
	private Integer idUsuario;
	
	private List<Integer> lstRolesAsignados;

}
