package com.petcare.mascota.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.petcare.mascota.model.Mascota;
import com.petcare.mascota.repository.MascotaRepository;

public class MascotaServiceTest {
     @Mock
    private MascotaRepository mascotaRepository;

    @InjectMocks
    private MascotaService mascotaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerPorId() {
        Mascota mascota = new Mascota();
        mascota.setId(3L);
        mascota.setNombre("Firulais");

        when(mascotaRepository.findById(3L)).thenReturn(Optional.of(mascota));

        Optional<Mascota> resultado = mascotaService.obtenerPorId(3L);
        assertTrue(resultado.isPresent());
        assertEquals("Firulais", resultado.get().getNombre());
    }
}
