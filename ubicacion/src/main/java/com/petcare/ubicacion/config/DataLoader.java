package com.petcare.ubicacion.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petcare.ubicacion.model.Comuna;
import com.petcare.ubicacion.model.Direccion;
import com.petcare.ubicacion.model.Region;
import com.petcare.ubicacion.repository.ComunaRepository;
import com.petcare.ubicacion.repository.DireccionRepository;
import com.petcare.ubicacion.repository.RegionRepository;
@Component
public class DataLoader implements CommandLineRunner {
     @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private ComunaRepository comunaRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public void run(String... args) {
        if (regionRepository.count() == 0 && comunaRepository.count() == 0 && direccionRepository.count() == 0) {

            // Crear región
            Region region = new Region();
            region.setNombre("Región Metropolitana");

            // Crear comuna
            Comuna comuna = new Comuna();
            comuna.setNombre("Santiago");
            comuna.setRegion(region);

            // Asignar comuna a región
            region.setComunas(List.of(comuna));

            // Guardar región
            regionRepository.save(region);

            // Crear dirección
            Direccion direccion = new Direccion();
            direccion.setCalle("Avenida Siempre Viva");
            direccion.setNumero("123");
            direccion.setComuna(comuna);
            direccion.setUsuarioId(1L); // Cambiar esto si el usuario tiene otro ID

            // Guardar dirección
            direccionRepository.save(direccion);

            System.out.println("Datos de ubicación precargados: Región, Comuna, Dirección.");
        }
    }
}
