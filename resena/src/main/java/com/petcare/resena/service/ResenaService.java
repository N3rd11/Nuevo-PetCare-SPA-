package com.petcare.resena.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.resena.model.Resena;
import com.petcare.resena.repository.ResenaRepository;

@Service
public class ResenaService {
    @Autowired
    private ResenaRepository repository;

    public List<Resena> listar() {
        return repository.findAll();
    }

    public Optional<Resena> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Resena guardar(Resena reseña) {
        reseña.setActiva(true);
        return repository.save(reseña);
    }

    public Resena actualizar(Long id, Resena reseña) {
        return repository.findById(id).map(r -> {
            r.setComentario(reseña.getComentario());
            r.setCalificacion(reseña.getCalificacion());
            r.setFecha(reseña.getFecha());
            return repository.save(r);
        }).orElse(null);
    }

    public void eliminarLogico(Long id) {
        repository.findById(id).ifPresent(r -> {
            r.setActiva(false);
            repository.save(r);
        });
    }

    public List<Resena> obtenerPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

}
