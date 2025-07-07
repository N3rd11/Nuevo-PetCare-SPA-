package com.petcare.raza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.raza.model.Raza;
import com.petcare.raza.repository.RazaRepository;

@Service
public class RazaService {
    @Autowired
    private RazaRepository repository;

    public List<Raza> listar() {
        return repository.findAll();
    }

    public Optional<Raza> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Raza guardar(Raza raza) {
        return repository.save(raza);
    }

    public Raza actualizar(Long id, Raza raza) {
        return repository.findById(id).map(r -> {
            r.setNombre(raza.getNombre());
            return repository.save(r);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}
