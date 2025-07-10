package com.petcare.resena.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.petcare.resena.model.Resena;
import com.petcare.resena.repository.ResenaRepository;

public class ResenaServiceTest {
    @Mock
    private ResenaRepository resenaRepository;

    @InjectMocks
    private ResenaService resenaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerPorId() {
        Resena resena = new Resena();
        resena.setId(5L);
        resena.setComentario("Muy buen servicio");

        when(resenaRepository.findById(5L)).thenReturn(Optional.of(resena));

        Optional<Resena> resultado = resenaService.obtenerPorId(5L);
        assertTrue(resultado.isPresent());
        assertEquals("Muy buen servicio", resultado.get().getComentario());
    }
}
