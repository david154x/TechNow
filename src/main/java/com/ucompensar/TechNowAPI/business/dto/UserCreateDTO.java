package com.ucompensar.TechNowAPI.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Hidden
public class UserCreateDTO {
	
    private String nuevoUsuario;
	
    private String nuevaContrasena;
    
	private String numeroDocumento;
	
    private String primerNombre;
	
	private String segundoNombre;
	
	private String primerApellido;
	
	private String segundoApellido;
	
	private String direccion;
	
	private String telefono;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String fechaNacimiento;
	
	private String genero;

}

