package com.example.reserva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reserva.model.reserva;
import com.example.reserva.repository.reservaRepository;

@Service
public class reservaService {

     @Autowired
    private reservaRepository ReservaRepository;

    // Obtener todas las reservas
    public List<reserva> getReservas() {
        return ReservaRepository.findAll();
    }

    // Obtener una reserva por ID
    public reserva getReserva(Long id) {
        return ReservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    // Crear una nueva reserva
    public reserva saveReserva(reserva nueva) {
        return ReservaRepository.save(nueva);
    }

    // Actualizar una reserva existente
    public reserva updateReserva(Long id, reserva actualizada) {
        reserva existente = ReservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        existente.setFechaReserva(actualizada.getFechaReserva());
        existente.setEstadoReserva(actualizada.getEstadoReserva());
        return ReservaRepository.save(existente);
    }

    // Eliminar una reserva
    public void deleteReserva(Long id) {
        ReservaRepository.deleteById(id);
    }

}
