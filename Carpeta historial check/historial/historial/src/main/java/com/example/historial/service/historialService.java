package com.example.historial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.historial.model.historial;
import com.example.historial.repository.historialRepository;

@Service

public class historialService {


    @Autowired
    private historialRepository HistorialRepository;

    // Obtener todos los historiales
    public List<historial> getHistoriales() {
        return HistorialRepository.findAll();
    }

    // Obtener un historial por ID
    public historial getHistorial(Long id) {
        return HistorialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));
    }

    // Obtener historiales por ID de mascota
    public List<historial> getPorMascota(Long mascotaId) {
        return HistorialRepository.findByMascotaId(mascotaId);
    }

    // Crear un historial
    public historial saveHistorial(historial historial) {
        return HistorialRepository.save(historial);
    }

    // Actualizar historial
    public historial updateHistorial(Long id, historial datosNuevos) {
        historial existente = HistorialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));

        existente.setFechaHistorial(datosNuevos.getFechaHistorial());
        existente.setTratamiento(datosNuevos.getTratamiento());
        existente.setDiagnostico(datosNuevos.getDiagnostico());
        

        return HistorialRepository.save(existente);
    }

    // Eliminar historial
    public void deleteHistorial(Long id) {
        if (!HistorialRepository.existsById(id)) {
            throw new RuntimeException("Historial no encontrado");
        }
        HistorialRepository.deleteById(id);
    }
}
