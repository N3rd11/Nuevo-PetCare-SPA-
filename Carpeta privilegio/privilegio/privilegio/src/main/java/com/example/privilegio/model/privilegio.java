package com.example.privilegio.model;

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
@Table(name = "privilegio")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class privilegio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrivilegio;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;
    
}
