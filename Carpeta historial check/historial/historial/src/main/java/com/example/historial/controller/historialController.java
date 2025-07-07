package com.example.historial.controller;

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

import com.example.historial.model.historial;
import com.example.historial.service.historialService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/historial")
@Tag(name = "Historial", description = "CRUD de Historiales")
public class historialController {

    @Autowired
    private historialService historialService;

    // HISTORIAL ------------------------

    @GetMapping
    @Operation(summary = "Listar todos los historiales")
    public ResponseEntity<List<historial>> obtenerHistoriales() {
        List<historial> historiales = historialService.getHistoriales();
        if (historiales.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(historiales);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener historial por ID")
    public ResponseEntity<historial> obtenerHistorial(@PathVariable Long id) {
        try {
            historial historial = historialService.getHistorial(id);
            return ResponseEntity.ok(historial);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Crear nuevo historial")
    public ResponseEntity<historial> guardarHistorial(@RequestBody historial historial) {
        return ResponseEntity.status(201).body(historialService.saveHistorial(historial));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar historial existente")
    public ResponseEntity<historial> actualizarHistorial(@PathVariable Long id, @RequestBody historial historialActualizado) {
        try {
            historial actualizado = historialService.updateHistorial(id, historialActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar historial por ID")
    public ResponseEntity<Void> eliminarHistorial(@PathVariable Long id) {
        try {
            historialService.deleteHistorial(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}