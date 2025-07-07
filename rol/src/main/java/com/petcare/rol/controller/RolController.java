
package com.petcare.rol.controller;

import com.petcare.rol.model.Rol;
import com.petcare.rol.service.RolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@Tag(name = "Rol", description = "CRUD de roles de usuario")
public class RolController {

    @Autowired
    private RolService rolService;

    @Operation(summary = "Listar todos los roles")
    @GetMapping
    public List<Rol> getAll() {
        return rolService.obtenerTodos();
    }

    @Operation(summary = "Obtener rol por ID")
    @GetMapping("/{id}")
    public Rol getById(@PathVariable Long id) {
        return rolService.obtenerPorId(id).orElse(null);
    }

    @Operation(summary = "Crear nuevo rol")
    @PostMapping
    public Rol create(@RequestBody Rol rol) {
        return rolService.crear(rol);
    }

    @Operation(summary = "Actualizar rol")
    @PutMapping("/{id}")
    public Rol update(@PathVariable Long id, @RequestBody Rol rol) {
        return rolService.actualizar(id, rol);
    }

    @Operation(summary = "Eliminar rol")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        rolService.eliminar(id);
    }
}
