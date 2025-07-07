package com.petcare.raza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.raza.model.Raza;
import com.petcare.raza.service.RazaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/razas")
@Tag(name = "Raza", description = "Crud raza")
public class RazaController {
    @Autowired
    private RazaService razaService;

    @Operation(summary = "Listar todas las razas")
    @GetMapping
    public List<Raza> getAll() {
        return razaService.listar();
    }

    @Operation(summary = "Obtener raza por ID")
    @GetMapping("/{id}")
    public Raza getById(@PathVariable Long id) {
        return razaService.obtenerPorId(id).orElse(null);
    }

    @Operation(summary = "Crear nueva raza")
    @PostMapping
    public Raza create(@RequestBody Raza raza) {
        return razaService.guardar(raza);
    }

    @Operation(summary = "Actualizar raza")
    @PutMapping("/{id}")
    public Raza update(@PathVariable Long id, @RequestBody Raza raza) {
        return razaService.actualizar(id, raza);
    }

    @Operation(summary = "Eliminar raza")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        razaService.eliminar(id);
    }

}
