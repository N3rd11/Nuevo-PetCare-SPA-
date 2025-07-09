package com.example.estado.config;


import com.example.estado.model.estado;
import com.example.estado.repository.estadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private estadoRepository EstadoRepository;

    @Override
    public void run(String... args) {
        if (EstadoRepository.count() == 0) {
            estado activo = new estado();
            activo.setNombreEstado("Activo");
            EstadoRepository.save(activo);

            estado inactivo = new estado();
            inactivo.setNombreEstado("Inactivo");
            EstadoRepository.save(inactivo);

            System.out.println("Estados precargados: Activo e Inactivo");
        }
    }
}
