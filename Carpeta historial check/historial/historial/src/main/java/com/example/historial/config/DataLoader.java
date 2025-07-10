package com.example.historial.config;

import com.example.historial.model.historial;
import com.example.historial.repository.historialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private historialRepository HistorialRepository;

    @Override
    public void run(String... args) {
        if (HistorialRepository.count() == 0) {
            historial h1 = new historial();
            h1.setTratamiento("Usar el cono de la verguenza por 3 semanas");
            HistorialRepository.save(h1);

            historial h2 = new historial();
            h2.setTratamiento("Dosis de gotas anti garrapatas 2 veces al día");
            HistorialRepository.save(h2);

            System.out.println("Historiales precargados");
        }
    }
}
