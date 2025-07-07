package com.example.estado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estado.model.estado;
import com.example.estado.repository.estadoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class estadoService {
    @Autowired
    private estadoRepository EstadoRepository;

    // Método para obtener todos los estados
    public List<estado> getEstados() {
        return EstadoRepository.findAll();
    }

    // Método para obtener un estado por su ID
    public estado getEstado(Long id) {
        return EstadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
    }

    // Método para crear un nuevo estado
    public estado saveEstado(estado estado) {
        return EstadoRepository.save(estado);
    }
    
    // Método para actualizar un estado existente
    public estado updateEstado(Long id, estado estadoActualizado) {
        estado existente = EstadoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
    
        existente.setNombreEstado(estadoActualizado.getNombreEstado());
        return EstadoRepository.save(existente);
    }

    // Método para eliminar un estado
    public void deleteEstado(Long id) {
        if (!EstadoRepository.existsById(id)) {
            throw new RuntimeException("Estado no encontrado");
        }
        EstadoRepository.deleteById(id);
    }
}
