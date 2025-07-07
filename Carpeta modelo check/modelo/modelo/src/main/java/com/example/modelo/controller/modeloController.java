package com.example.modelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.model.modelo;
import com.example.modelo.service.modelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@Controller
@RestController
@RequestMapping("/api/v1/modelo")
@Tag(name = "Modelo", description = "CRUD de Modelos")
public class modeloController {

    @Autowired
    private modelService modeloService;

    // MODELO ------------------------

    @GetMapping
    @Operation(summary = "Listar todos los modelos")
    public ResponseEntity<List<modelo>> obtenerModelos() {
        List<modelo> modelos = modeloService.getModelos();
        if (modelos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(modelos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener modelo por ID")
    public ResponseEntity<modelo> obtenerModelo(@PathVariable Long id) {
        try {
            modelo modelo = modeloService.getModelo(id);
            return ResponseEntity.ok(modelo);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Crear nuevo modelo")
    public ResponseEntity<modelo> guardarModelo(@RequestBody modelo modelo) {
        return ResponseEntity.status(201).body(modeloService.saveModelo(modelo));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar modelo existente")
    public ResponseEntity<modelo> actualizarModelo(@PathVariable Long id, @RequestBody modelo modeloActualizado) {
        try {
            modelo actualizado = modeloService.updateModelo(id, modeloActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar modelo por ID")
    public ResponseEntity<Void> eliminarModelo(@PathVariable Long id) {
        try {
            modeloService.deleteModelo(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
