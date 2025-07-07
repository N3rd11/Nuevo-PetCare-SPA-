package com.example.categoria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.categoria.model.categoria;
import com.example.categoria.repository.categoriaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class categoriaService {
    @Autowired
     private categoriaRepository CategoriaRepository;

    // Obtener todas las categorías
    public List<categoria> getCategorias() {
        return CategoriaRepository.findAll();
    }

    // Obtener una categoría por ID
    public categoria getCategoria(Long id) {
        return CategoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    // Crear una nueva categoría
    public categoria saveCategoria(categoria categoriaNueva) {
        return CategoriaRepository.save(categoriaNueva);
    }

    // Actualizar una categoría existente
    public categoria updateCategoria(Long id, categoria categoriaActualizada) {
        categoria categoriaExistente = CategoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        categoriaExistente.setNombreCategoria(categoriaActualizada.getNombreCategoria());
        return CategoriaRepository.save(categoriaExistente);
    }

    // Eliminar una categoría
    public void deleteCategoria(Long id) {
        CategoriaRepository.deleteById(id);
    }
} 


