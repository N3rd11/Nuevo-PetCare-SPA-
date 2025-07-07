package com.petcare.rol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.rol.model.Rol;
import com.petcare.rol.repository.RolRepository;

@Service
public class RolService {
    @Autowired
    private RolRepository repository;

    public List<Rol> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Rol> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Rol crear(Rol rol) {
        return repository.save(rol);
    }

    public Rol actualizar(Long id, Rol rol) {
        return repository.findById(id)
                .map(r -> {
                    r.setNombre(rol.getNombre());
                    r.setDescripcion(rol.getDescripcion());
                    return repository.save(r);
                })
                .orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}
