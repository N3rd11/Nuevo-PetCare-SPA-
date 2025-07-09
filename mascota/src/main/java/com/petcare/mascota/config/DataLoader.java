package com.petcare.mascota.config;

import com.petcare.mascota.model.Mascota;
import com.petcare.mascota.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public void run(String... args) {
        if (mascotaRepository.count() == 0) {
            Mascota mascota = new Mascota();
            mascota.setNombre("Firulais");
            mascota.setGenero("Macho");

            mascota.setUsuarioId(1L); 
            mascota.setEspecieId(1L);  
            mascota.setRazaId(1L);     

            mascotaRepository.save(mascota);

            System.out.println("Mascota precargada: Firulais");
        }
    }
}
