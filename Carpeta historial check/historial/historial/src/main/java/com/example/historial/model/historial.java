package com.example.historial.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "historial")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class historial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaHistorial;

    @Column(nullable = false)
    private String tratamiento;

    @Column(nullable = false)
    private String diagnostico;

    @Column(name = "mascota_id", nullable = false)
    private Long mascotaId; 

}
