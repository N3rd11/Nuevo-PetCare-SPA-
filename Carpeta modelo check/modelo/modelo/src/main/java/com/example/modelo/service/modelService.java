package com.example.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modelo.model.modelo;
import com.example.modelo.repository.modeloRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class modelService {
    @Autowired
    private modeloRepository ModeloRepository;

    // Obtener todos los modelos
    public List<modelo> getModelos() {
        return ModeloRepository.findAll();
    }

    // Obtener un modelo por ID
    public modelo getModelo(Long id) {
        return ModeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo no encontrado"));
    }

    // Crear un nuevo modelo
    public modelo saveModelo(modelo modeloNuevo) {
        return ModeloRepository.save(modeloNuevo);
    }

    // Actualizar un modelo existente
    public modelo updateModelo(Long id, modelo modeloActualizado) {
        modelo modeloExistente = ModeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo no encontrado"));

        modeloExistente.setNombreModelo(modeloActualizado.getNombreModelo());
        return ModeloRepository.save(modeloExistente);
    }

    // Eliminar un modelo
    public void deleteModelo(Long id) {
        ModeloRepository.deleteById(id);
    }
}

