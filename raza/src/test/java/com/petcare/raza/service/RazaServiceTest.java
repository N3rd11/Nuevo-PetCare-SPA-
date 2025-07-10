package com.petcare.raza.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.petcare.raza.model.Raza;
import com.petcare.raza.repository.RazaRepository;

public class RazaServiceTest {
    @Mock
    private RazaRepository razaRepository;

    @InjectMocks
    private RazaService razaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerPorId() {
        Raza raza = new Raza();
        raza.setId(2L);
        raza.setNombre("Labrador");

        when(razaRepository.findById(2L)).thenReturn(Optional.of(raza));

        Optional<Raza> resultado = razaService.obtenerPorId(2L);
        assertTrue(resultado.isPresent());
        assertEquals("Labrador", resultado.get().getNombre());
    }
}
