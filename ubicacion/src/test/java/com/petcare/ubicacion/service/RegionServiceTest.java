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

import com.petcare.ubicacion.model.Region;
import com.petcare.ubicacion.repository.RegionRepository;

public class RegionServiceTest {
    @Mock
    private RegionRepository regionRepository;

    @InjectMocks
    private RegionService regionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerRegionPorId() {
        Region region = new Region();
        region.setId(1L);
        region.setNombre("Valparaíso");

        when(regionRepository.findById(1L)).thenReturn(Optional.of(region));

        Optional<Region> resultadoOptional = regionService.buscarRegionPorId(1L);
        assertTrue(resultadoOptional.isPresent());
        assertEquals("Valparaíso", resultadoOptional.get().getNombre());
    }
}
