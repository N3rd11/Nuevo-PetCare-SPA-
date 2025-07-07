package com.example.privilegio.controller;

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

import com.example.privilegio.model.privilegio;
import com.example.privilegio.service.privilegioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/privilegio")
@Tag(name = "Privilegio", description = "CRUD de Privilegios")
public class privilegioController {

    @Autowired
    private privilegioService privilegioService;

    // PRIVILEGIO ------------------------

    @GetMapping
    @Operation(summary = "Listar todos los privilegios")
    public ResponseEntity<List<privilegio>> obtenerPrivilegios() {
        List<privilegio> privilegios = privilegioService.getPrivilegios();
        if (privilegios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(privilegios);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener privilegio por ID")
    public ResponseEntity<privilegio> obtenerPrivilegio(@PathVariable Long id) {
        try {
            privilegio privilegio = privilegioService.getPrivilegio(id);
            return ResponseEntity.ok(privilegio);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Crear nuevo privilegio")
    public ResponseEntity<privilegio> guardarPrivilegio(@RequestBody privilegio privilegio) {
        return ResponseEntity.status(201).body(privilegioService.savePrivilegio(privilegio));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar privilegio existente")
    public ResponseEntity<privilegio> actualizarPrivilegio(@PathVariable Long id, @RequestBody privilegio privilegioActualizado) {
        try {
            privilegio actualizado = privilegioService.updatePrivilegio(id, privilegioActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar privilegio por ID")
    public ResponseEntity<Void> eliminarPrivilegio(@PathVariable Long id) {
        try {
            privilegioService.deletePrivilegio(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}