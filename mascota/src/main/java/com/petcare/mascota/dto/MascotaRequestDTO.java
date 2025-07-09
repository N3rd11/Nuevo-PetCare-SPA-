package com.petcare.mascota.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MascotaRequestDTO {
    private String nombre;
    private String genero;
    private Long usuarioId;
    private Long razaId;
    private Long especieId;  

}
