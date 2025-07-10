package com.petcare.resena.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String nombrecompleto;
    private String correo;
}
