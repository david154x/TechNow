package com.ucompensar.TechNowAPI.business.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Hidden
public class UserCreateDTO {
	
	private String nombreUsuario;
	private String claveUsuario;

}
