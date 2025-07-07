package com.example.reserva.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "reserva")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @Column(nullable = false)
    private Date fechaReserva;
    
    @Column(nullable = false)
    private String estadoReserva;
    
    @Column(nullable = false)
    private Long idClinica;

    //FK de la tabla servicios
    @Column(nullable = false) 
    private Long idServicios;

    //FK de la tabla estado
    @Column(nullable = false)
    private Long idEstado;

    //FK de la tabla mascota
    @Column(nullable = false)
    private Long idMascota;

    
}
