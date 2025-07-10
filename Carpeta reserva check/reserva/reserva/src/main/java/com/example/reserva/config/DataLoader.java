package com.example.reserva.config;

import com.example.reserva.model.reserva;
import com.example.reserva.repository.reservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private reservaRepository ReservaRepository;

    @Override
    public void run(String... args) {
        if (ReservaRepository.count() == 0) {
            reserva r1 = new reserva();
            r1.setFechaReserva(null);
            ReservaRepository.save(r1);

            reserva r2 = new reserva();
            r2.setFechaReserva(null);
            ReservaRepository.save(r2);

            System.out.println("Reservas precargadas");
        }
    }
}
