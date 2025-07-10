package com.petcare.resena.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.petcare.resena.model.Resena;
import com.petcare.resena.repository.ResenaRepository;

public class DataLoader implements CommandLineRunner {
    @Autowired
    private ResenaRepository resenaRepository;

    @Override
    public void run(String... args) {
        if (resenaRepository.count() == 0) {
            Resena resena = new Resena();
            resena.setUsuarioId(1L);
            resena.setServicioId(1L); 
            resena.setComentario("Muy buen servicio");
            resena.setCalificacion(5);
            resena.setFecha("2025-07-09");
            resena.setActiva(true);

            resenaRepository.save(resena);
            System.out.println("Reseña precargada.");
        }
    }
}
