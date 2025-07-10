package com.petcare.rol.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.petcare.rol.model.Rol;
import com.petcare.rol.repository.RolRepository;

public class RolServiceTest {
     @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private RolService rolService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerPorId() {
        Rol rol = new Rol();
        rol.setId(1L);
        rol.setNombre("ADMIN");

        when(rolRepository.findById(1L)).thenReturn(Optional.of(rol));

        Optional<Rol> resultado = rolService.obtenerPorId(1L);
        assertTrue(resultado.isPresent());
        assertEquals("ADMIN", resultado.get().getNombre());
    }
}
