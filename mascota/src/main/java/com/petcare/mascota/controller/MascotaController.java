package com.petcare.mascota.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.mascota.dto.MascotaRequestDTO;
import com.petcare.mascota.model.Mascota;
import com.petcare.mascota.service.MascotaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/mascotas")
@Tag(name = "Mascota", description = "Crud mascotas")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

   @PostMapping
public ResponseEntity<Mascota> create(@RequestBody MascotaRequestDTO dto) {
    System.out.println("➡ Registrando desde DTO: " + dto);
    return ResponseEntity.ok(mascotaService.registrarDesdeDto(dto));
}
    @GetMapping
    public List<Mascota> getAll() {
        return mascotaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Mascota>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> update(@PathVariable Long id, @RequestBody Mascota mascota) {
        return ResponseEntity.ok(mascotaService.actualizar(id, mascota));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mascotaService.eliminar(id);
    }
}
