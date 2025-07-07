package com.petcare.resena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.resena.model.Resena;
import com.petcare.resena.service.ResenaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/resenas")
@Tag(name = "Reseñas", description = "Crud reseñas ")
public class ResenaController {
    @Autowired
    private ResenaService resenaService;

    @Operation(summary = "Listar todas las reseñas")
    @GetMapping
    public List<Resena> getAll() {
        return resenaService.listar();
    }

    @Operation(summary = "Obtener reseña por ID")
    @GetMapping("/{id}")
    public Resena getById(@PathVariable Long id) {
        return resenaService.obtenerPorId(id).orElse(null);
    }

    @Operation(summary = "Crear nueva reseña")
    @PostMapping
    public Resena create(@RequestBody Resena resena) {
        return resenaService.guardar(resena);
    }

    @Operation(summary = "Actualizar reseña")
    @PutMapping("/{id}")
    public Resena update(@PathVariable Long id, @RequestBody Resena resena) {
        return resenaService.actualizar(id, resena);
    }

    @Operation(summary = "Cancelar reseña (eliminación lógica)")
    @DeleteMapping("/{id}")
    public void cancel(@PathVariable Long id) {
        resenaService.eliminarLogico(id);
    }

    @Operation(summary = "Listar reseñas por ID de usuario")
    @GetMapping("/usuario/{usuarioId}")
    public List<Resena> getByUsuario(@PathVariable Long usuarioId) {
        return resenaService.obtenerPorUsuario(usuarioId);
    }

}
