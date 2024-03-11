package com.ucompensar.TechNowAPI.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VerificarPasswordDTO {
    private String nuevoUsuario;
    private String nuevaContrasena;
}
