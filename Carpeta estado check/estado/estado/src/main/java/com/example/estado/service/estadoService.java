package com.example.estado.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.estado.model.estado;
import com.example.estado.repository.estadoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class estadoService {

    private final estadoRepository estadoRepository;

    public estadoService(estadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    // Método para obtener todos los estados
    public List<estado> getEstados() {
        return estadoRepository.findAll();
    }

    // Método para obtener un estado por su ID
    public estado getEstado(Long id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
    }

    // Método para crear un nuevo estado
    public estado saveEstado(estado estado) {
        return estadoRepository.save(estado);
    }

    // Método para actualizar un estado existente
    public estado updateEstado(Long id, estado estadoActualizado) {
        estado existente = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        existente.setNombreEstado(estadoActualizado.getNombreEstado());
        return estadoRepository.save(existente);
    }

    // Método para eliminar un estado
    public void deleteEstado(Long id) {
        if (!estadoRepository.existsById(id)) {
            throw new RuntimeException("Estado no encontrado");
        }
        estadoRepository.deleteById(id);
    }
}
