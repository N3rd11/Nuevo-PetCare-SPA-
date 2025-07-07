package com.example.estado.controller;

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

import com.example.estado.model.estado;
import com.example.estado.service.estadoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/estado")
@Tag(name = "Estado", description = "CRUD de Estados")
public class modelController {

    @Autowired
    private estadoService EstadoService;

    // ESTADO ------------------------

    @GetMapping
    @Operation(summary = "Listar todos los estados")
    public ResponseEntity<List<estado>> obtenerEstados() {
        List<estado> estados = EstadoService.getEstados();
        if (estados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener estado por ID")
    public ResponseEntity<estado> obtenerEstado(@PathVariable Long id) {
        try {
            estado estado = EstadoService.getEstado(id);
            return ResponseEntity.ok(estado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Crear nuevo estado")
    public ResponseEntity<estado> guardarEstado(@RequestBody estado estado) {
        return ResponseEntity.status(201).body(EstadoService.saveEstado(estado));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar estado existente")
    public ResponseEntity<estado> actualizarEstado(@PathVariable Long id, @RequestBody estado estadoActualizado) {
        try {
            estado actualizado = EstadoService.updateEstado(id, estadoActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar estado por ID")
    public ResponseEntity<Void> eliminarEstado(@PathVariable Long id) {
        try {
            EstadoService.deleteEstado(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}


