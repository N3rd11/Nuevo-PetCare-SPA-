package com.example.servicios.config;

import com.example.servicios.model.servicios;
import com.example.servicios.repository.serviciosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private serviciosRepository ServicioRepository;

    @Override
    public void run(String... args) {
        if (ServicioRepository.count() == 0) {
            servicios s1 = new servicios();
            s1.setNombreServicios("Baño completo");
            ServicioRepository.save(s1);

            servicios s2 = new servicios();
            s2.setNombreServicios("Corte de pelo");
            ServicioRepository.save(s2);

            System.out.println("Servicios precargados: Baño completo, Corte de pelo");
        }
    }
}

