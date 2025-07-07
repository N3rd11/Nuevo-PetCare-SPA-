package com.example.servicios.controller;

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

import com.example.servicios.model.servicios;
import com.example.servicios.service.serviciosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/servicio")
@Tag(name = "Servicio", description = "CRUD de Servicios")
public class ServicioController {

    @Autowired
    private serviciosService servicioService;

    // SERVICIO ------------------------

    @GetMapping
    @Operation(summary = "Listar todos los servicios")
    public ResponseEntity<List<servicios>> obtenerServicios() {
        List<servicios> servicios = servicioService.getServicios();
        if (servicios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(servicios);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener servicio por ID")
    public ResponseEntity<servicios> obtenerServicio(@PathVariable Long id) {
        try {
            servicios servicio = servicioService.getServicio(id);
            return ResponseEntity.ok(servicio);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Crear nuevo servicio")
    public ResponseEntity<servicios> guardarServicio(@RequestBody servicios servicio) {
        return ResponseEntity.status(201).body(servicioService.saveServicio(servicio));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar servicio existente")
    public ResponseEntity<servicios> actualizarServicio(@PathVariable Long id, @RequestBody servicios servicioActualizado) {
        try {
            servicios actualizado = servicioService.updateServicio(id, servicioActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar servicio por ID")
    public ResponseEntity<Void> eliminarServicio(@PathVariable Long id) {
        try {
            servicioService.deleteServicio(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
