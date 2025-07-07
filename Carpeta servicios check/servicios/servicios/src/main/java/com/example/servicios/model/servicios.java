package com.example.servicios.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Servicios")
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicios;


    @Column(nullable = false)
    private String nombreServicios;

    @Column(nullable = false)
    private String descripcionServicios;

    @Column(nullable = false)
    private int costos;

    //FK de categoria
    @Column(nullable = false)
    private Long idCategoria;

    //Falta la de reseña
    @Column(nullable = false)
    private Long id;
    
}
