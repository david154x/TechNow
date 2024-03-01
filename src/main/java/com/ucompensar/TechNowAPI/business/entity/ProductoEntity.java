package com.ucompensar.TechNowAPI.business.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_prod")
	private Integer idProducto;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_prod", nullable = false)
    private TipoProductoEntity tipoProductoEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca", nullable = false)
	private MarcaEntity marcaEntity;
	
	@Column(name = "de_prod", nullable = false)
	private String nombreProducto;
	
	@Column(name = "de_prod_desc", nullable = false)
	private String descripcionProducto;

	@Column(name = "vr_prod", nullable = false)
	private BigDecimal valorProducto;
	
	@Column(name = "de_ruta", nullable = false)
	private String ubicacionFoto;

	@Column(name = "id_acti", columnDefinition = "varchar(1)", nullable = false)
	private String idActivo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="fe_crea", nullable = false)
	private Date fechaCreacion;

}
