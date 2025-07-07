package com.example.categoria.controller;

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

import com.example.categoria.model.categoria;
import com.example.categoria.service.categoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/categoria")
@Tag(name = "Categoría", description = "CRUD de Categorías")
public class categoriaController {

    @Autowired
    private categoriaService CategoriaService;

    // CATEGORÍA ------------------------

    @GetMapping
    @Operation(summary = "Listar todas las categorías")
    public ResponseEntity<List<categoria>> obtenerCategorias() {
        List<categoria> categorias = CategoriaService.getCategorias();
        if (categorias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener categoría por ID")
    public ResponseEntity<categoria> obtenerCategoria(@PathVariable Long id) {
        try {
            categoria categoria = CategoriaService.getCategoria(id);
            return ResponseEntity.ok(categoria);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Crear nueva categoría")
    public ResponseEntity<categoria> guardarCategoria(@RequestBody categoria nueva) {
        return ResponseEntity.status(201).body(CategoriaService.saveCategoria(nueva));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una categoría")
    public ResponseEntity<categoria> actualizarCategoria(@PathVariable Long id, @RequestBody categoria actualizada) {
        try {
            categoria actualizadaCategoria = CategoriaService.updateCategoria(id, actualizada);
            return ResponseEntity.ok(actualizadaCategoria);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar categoría por ID")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        try {
            CategoriaService.deleteCategoria(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
    


