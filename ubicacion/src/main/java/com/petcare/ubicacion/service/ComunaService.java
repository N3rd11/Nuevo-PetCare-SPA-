package com.petcare.ubicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.ubicacion.model.Comuna;
import com.petcare.ubicacion.repository.ComunaRepository;

@Service
public class ComunaService {
    @Autowired
    private ComunaRepository comunaRepo;

    public List<Comuna> listarComunas() {
        return comunaRepo.findAll();
    }
    public Comuna guardarComuna(Comuna comuna) {
        return comunaRepo.save(comuna);
    }
    public Optional<Comuna> buscarComunaPorId(Long id) {
        return comunaRepo.findById(id);
    }
    public void eliminarComuna(Long id) {
        comunaRepo.deleteById(id);
    }

}
