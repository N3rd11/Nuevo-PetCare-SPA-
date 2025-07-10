package com.petcare.usuario.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RolDTO {
    private Long id;
    private String nombre;
    private String descripcion;

}
