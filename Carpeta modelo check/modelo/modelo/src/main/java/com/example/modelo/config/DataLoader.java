package com.example.modelo.config;

import com.example.modelo.model.modelo;
import com.example.modelo.repository.modeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private modeloRepository ModeloRepository;

    @Override
    public void run(String... args) {
        if (ModeloRepository.count() == 0) {
            modelo m1 = new modelo();
            m1.setNombreModelo("Corta uñas");
            ModeloRepository.save(m1);

            modelo m2 = new modelo();
            m2.setNombreModelo("Secador");
            ModeloRepository.save(m2);

            System.out.println("Modelos precargados: Corta uñas, Secador");
        }
    }
}
