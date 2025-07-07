package com.petcare.mascota.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.mascota.model.Mascota;
import com.petcare.mascota.service.MascotaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/mascotas")
@Tag(name = "Mascota", description = "Crud mascotas")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @Operation(summary = "Listar todas las mascotas")
    @GetMapping
    public List<Mascota> getAll() {
        return mascotaService.listar();
    }

    @Operation(summary = "Obtener mascota por ID")
    @GetMapping("/{id}")
    public Mascota getById(@PathVariable Long id) {
        return mascotaService.obtenerPorId(id).orElse(null);
    }

    @Operation(summary = "Crear nueva mascota")
    @PostMapping
    public Mascota create(@RequestBody Mascota mascota) {
        return mascotaService.guardar(mascota);
    }

    @Operation(summary = "Actualizar mascota")
    @PutMapping("/{id}")
    public Mascota update(@PathVariable Long id, @RequestBody Mascota mascota) {
        return mascotaService.actualizar(id, mascota);
    }

    @Operation(summary = "Eliminar mascota")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mascotaService.eliminar(id);
    }

    @Operation(summary = "Listar mascotas por ID de usuario")
    @GetMapping("/usuario/{usuarioId}")
    public List<Mascota> getByUsuario(@PathVariable Long usuarioId) {
        return mascotaService.buscarPorUsuarioId(usuarioId);
    }

}
