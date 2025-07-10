package com.petcare.resena.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ServicioDTO {
    private Long id;
    private String nombreServicios;
    private String descripcionServicios;
}
