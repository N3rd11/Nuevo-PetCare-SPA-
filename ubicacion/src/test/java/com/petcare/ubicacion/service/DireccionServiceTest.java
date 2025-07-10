package com.petcare.ubicacion.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.petcare.ubicacion.model.Direccion;
import com.petcare.ubicacion.repository.DireccionRepository;

public class DireccionServiceTest {
    @Mock
    private DireccionRepository direccionRepository;

    @InjectMocks
    private DireccionService direccionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerPorId() {
        Direccion direccion = new Direccion();
        direccion.setId(100L);
        direccion.setCalle("Los Castaños 123");

        when(direccionRepository.findById(100L)).thenReturn(Optional.of(direccion));

        Direccion resultado = direccionService.buscarDireccionPorId(100L);
        assertEquals("Los Castaños 123", resultado.getCalle());
    }
}
