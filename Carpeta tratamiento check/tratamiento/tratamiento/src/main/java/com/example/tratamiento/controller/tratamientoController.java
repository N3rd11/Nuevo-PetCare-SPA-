package com.example.tratamiento.controller;

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

import com.example.tratamiento.model.Tratamiento;
import com.example.tratamiento.service.tratamientoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/tratamiento")
@Tag(name = "Tratamiento", description = "CRUD de Tratamientos")
public class tratamientoController {

    @Autowired
    private tratamientoService TratamientoService;

    // TRATAMIENTO ------------------------

    @GetMapping
    @Operation(summary = "Listar todos los tratamientos")
    public ResponseEntity<List<Tratamiento>> obtenerTratamientos() {
        List<Tratamiento> tratamientos = TratamientoService.getTratamientos();
        if (tratamientos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tratamientos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener tratamiento por ID")
    public ResponseEntity<Tratamiento> obtenerTratamiento(@PathVariable Long id) {
        try {
            Tratamiento tratamiento = TratamientoService.getTratamiento(id);
            return ResponseEntity.ok(tratamiento);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Crear nuevo tratamiento")
    public ResponseEntity<Tratamiento> guardarTratamiento(@RequestBody Tratamiento tratamiento) {
        return ResponseEntity.status(201).body(TratamientoService.saveTratamiento(tratamiento));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar tratamiento existente")
    public ResponseEntity<Tratamiento> actualizarTratamiento(@PathVariable Long id, @RequestBody Tratamiento tratamientoActualizado) {
        try {
            Tratamiento actualizado = TratamientoService.updateTratamiento(id, tratamientoActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar tratamiento por ID")
    public ResponseEntity<Void> eliminarTratamiento(@PathVariable Long id) {
        try {
            TratamientoService.deleteTratamiento(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}