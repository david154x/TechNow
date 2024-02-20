package com.ucompensar.TechNowAPI.business.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="persona")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="de_nomb_1", nullable = false)
	private String primerNombre;
	
	@Column(name="de_nomb_2", nullable = true)
	private String segundoNombre;
	
	@Column(name="de_ape_1", nullable = false)
	private String primerApellido;
	
	@Column(name="de_ape_2", nullable = true)
	private String segundoApellido;
	
	@Column(name="id_tipo_docu", nullable = false)
	private String tipoDocumento;
	
	@Column(name="nu_docu", nullable = false)
	private String numeroDocumento;
	
	@Column(name="id_gene", nullable = false)
	private String genero;
	
	@Column(name="fe_naci", nullable = false)
	private String fechaNacimiento;
	
	@Column(name="de_dire", nullable = false)
	private String email;
	
	@Column(name="de_tele", nullable = false)
	private String telefono;

}
