package com.petcare.ubicacion.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DireccionDetalleDTO {
    private Long id;
    private String calle;
    private String numero;
    private String comuna;
    private String region;
    private UsuarioDTO usuario;
}
