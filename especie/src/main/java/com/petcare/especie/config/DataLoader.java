package com.petcare.especie.config;

import org.springframework.stereotype.Component;
import com.petcare.especie.model.Especie;
import com.petcare.especie.repository.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EspecieRepository especieRepository;

    @Override
    public void run(String... args) {
        if (especieRepository.count() == 0) {
            Especie perro = new Especie();
            perro.setNombre("Perro");
            especieRepository.save(perro);

            Especie gato = new Especie();
            gato.setNombre("Gato");
            especieRepository.save(gato);

            System.out.println("Especies precargadas: Perro y Gato");
        }
    }

}
