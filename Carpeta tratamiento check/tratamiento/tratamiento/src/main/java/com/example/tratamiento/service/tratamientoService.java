package com.example.tratamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tratamiento.model.Tratamiento;
import com.example.tratamiento.repository.tratamientoRepository;

@Service

public class tratamientoService {
     @Autowired
    private tratamientoRepository TratamientoRepository;

    // Obtener todos los tratamientos
    public List<Tratamiento> getTratamientos() {
        return TratamientoRepository.findAll();
    }

    // Obtener un tratamiento por ID
    public Tratamiento getTratamiento(Long id) {
        return TratamientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tratamiento no encontrado"));
    }

    // Crear un nuevo tratamiento
    public Tratamiento saveTratamiento(Tratamiento nuevo) {
        return TratamientoRepository.save(nuevo);
    }

    // Actualizar un tratamiento existente
    public Tratamiento updateTratamiento(Long id, Tratamiento actualizado) {
        Tratamiento existente = TratamientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tratamiento no encontrado"));

        existente.setNombreTratamiento(actualizado.getNombreTratamiento());
        existente.setMedicamentoUtilizado(actualizado.getMedicamentoUtilizado());
        return TratamientoRepository.save(existente);
    }

    // Eliminar un tratamiento
    public void deleteTratamiento(Long id) {
        TratamientoRepository.deleteById(id);
    }

}
