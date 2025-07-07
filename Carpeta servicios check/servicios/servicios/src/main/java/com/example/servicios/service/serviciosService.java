package com.example.servicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicios.model.servicios;
import com.example.servicios.repository.serviciosRepository;

@Service
public class serviciosService {
    @Autowired
    
    private serviciosRepository ServicioRepository;

    // Obtener todos los servicios
    public List<servicios> getServicios() {
        return ServicioRepository.findAll();
    }

    // Obtener un servicio por ID
    public servicios getServicio(Long id) {
        return ServicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
    }

    // Crear un nuevo servicio
    public servicios saveServicio(servicios nuevo) {
        return ServicioRepository.save(nuevo);
    }

    // Actualizar un servicio existente
    public servicios updateServicio(Long id, servicios actualizado) {
        servicios existente = ServicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        existente.setNombreServicios(actualizado.getNombreServicios());
        existente.setDescripcionServicios(actualizado.getDescripcionServicios());
        return ServicioRepository.save(existente);
    }

    // Eliminar un servicio
    public void deleteServicio(Long id) {
        ServicioRepository.deleteById(id);
    }

}
