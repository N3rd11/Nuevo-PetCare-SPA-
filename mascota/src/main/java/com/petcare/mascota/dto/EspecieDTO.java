package com.petcare.mascota.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EspecieDTO {
    private Long id;
    private String nombre;
}
