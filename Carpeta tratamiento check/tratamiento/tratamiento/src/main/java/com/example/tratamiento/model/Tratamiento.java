package com.example.tratamiento.model;

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
@Table(name = "Tratamiento")
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTratamiento;

    @Column(nullable = false)
    private String nombreTratamiento;

    @Column(nullable = false)
    private String medicamentoUtilizado;

    @Column(nullable = false)
    private Long idHistorial;
}
