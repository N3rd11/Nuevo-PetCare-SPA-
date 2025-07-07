package com.example.reserva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reserva.model.reserva;
import com.example.reserva.service.reservaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/reserva")
@Tag(name = "Reserva", description = "CRUD de Reservas")
public class reservaController {

    @Autowired
    private reservaService reservaService;

    // RESERVA ------------------------

    @GetMapping
    @Operation(summary = "Listar todas las reservas")
    public ResponseEntity<List<reserva>> obtenerReservas() {
        List<reserva> reservas = reservaService.getReservas();
        if (reservas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener reserva por ID")
    public ResponseEntity<reserva> obtenerReserva(@PathVariable Long id) {
        try {
            reserva reserva = reservaService.getReserva(id);
            return ResponseEntity.ok(reserva);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Crear nueva reserva")
    public ResponseEntity<reserva> guardarReserva(@RequestBody reserva reserva) {
        return ResponseEntity.status(201).body(reservaService.saveReserva(reserva));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar reserva existente")
    public ResponseEntity<reserva> actualizarReserva(@PathVariable Long id, @RequestBody reserva reservaActualizada) {
        try {
            reserva actualizada = reservaService.updateReserva(id, reservaActualizada);
            return ResponseEntity.ok(actualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar reserva por ID")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        try {
            reservaService.deleteReserva(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
