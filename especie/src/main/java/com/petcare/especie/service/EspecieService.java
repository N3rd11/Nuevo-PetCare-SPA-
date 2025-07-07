package com.petcare.especie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.especie.model.Especie;
import com.petcare.especie.repository.EspecieRepository;

@Service
public class EspecieService {

    @Autowired
    private EspecieRepository repository;

    public List<Especie> listar() {
        return repository.findAll();
    }

    public Optional<Especie> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Especie guardar(Especie especie) {
        return repository.save(especie);
    }

    public Especie actualizar(Long id, Especie especie) {
        return repository.findById(id).map(e -> {
            e.setNombre(especie.getNombre());
            return repository.save(e);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}
