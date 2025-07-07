package com.petcare.especie.controller;

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

import com.petcare.especie.model.Especie;
import com.petcare.especie.service.EspecieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/especies")
@Tag(name = "Especies", description = "Crud especies")
public class EspecieController {
    @Autowired
    private EspecieService especieService;

    @Operation(summary = "Listar todas las especies")
    @GetMapping
    public List<Especie> getAll() {
        return especieService.listar();
    }

    @Operation(summary = "Obtener especie por ID")
    @GetMapping("/{id}")
    public Especie getById(@PathVariable Long id) {
        return especieService.obtenerPorId(id).orElse(null);
    }

    @Operation(summary = "Crear nueva especie")
    @PostMapping
    public Especie create(@RequestBody Especie especie) {
        return especieService.guardar(especie);
    }

    @Operation(summary = "Actualizar especie")
    @PutMapping("/{id}")
    public Especie update(@PathVariable Long id, @RequestBody Especie especie) {
        return especieService.actualizar(id, especie);
    }

    @Operation(summary = "Eliminar especie")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        especieService.eliminar(id);
    }

}
