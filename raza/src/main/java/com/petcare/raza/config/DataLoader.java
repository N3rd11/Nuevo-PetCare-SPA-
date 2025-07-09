package com.petcare.raza.config;

import com.petcare.raza.model.Raza;
import com.petcare.raza.repository.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
@Autowired
    private RazaRepository razaRepository;

    @Override
    public void run(String... args) {
        if (razaRepository.count() == 0) {
            Raza labrador = new Raza();
            labrador.setNombre("Labrador Retriever");
            razaRepository.save(labrador);

            Raza siames = new Raza();
            siames.setNombre("Siamés");
            razaRepository.save(siames);

            System.out.println("Razas precargadas: Labrador y Siamés");
        }
    }
}
