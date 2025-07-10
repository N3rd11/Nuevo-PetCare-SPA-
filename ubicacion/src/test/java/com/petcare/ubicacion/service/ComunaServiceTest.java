package com.petcare.ubicacion.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.petcare.ubicacion.model.Comuna;
import com.petcare.ubicacion.repository.ComunaRepository;

public class ComunaServiceTest {
    @Mock
    private ComunaRepository comunaRepository;

    @InjectMocks
    private ComunaService comunaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerPorId() {
        Comuna comuna = new Comuna();
        comuna.setId(10L);
        comuna.setNombre("Quilpué");

        when(comunaRepository.findById(10L)).thenReturn(Optional.of(comuna));

        Optional<Comuna> resultado = comunaService.buscarComunaPorId(10L);
        assertTrue(resultado.isPresent());
        assertEquals("Quilpué", resultado.get().getNombre());
    }
}
