package com.petcare.especie.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.petcare.especie.model.Especie;
import com.petcare.especie.repository.EspecieRepository;

public class EspecieServiceTest {
     @Mock
    private EspecieRepository especieRepository;

    @InjectMocks
    private EspecieService especieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerPorId() {
        Especie especie = new Especie();
        especie.setId(4L);
        especie.setNombre("Canino");

        when(especieRepository.findById(4L)).thenReturn(Optional.of(especie));

        Optional<Especie> resultado = especieService.obtenerPorId(4L);
        assertTrue(resultado.isPresent());
        assertEquals("Canino", resultado.get().getNombre());
    }
}
