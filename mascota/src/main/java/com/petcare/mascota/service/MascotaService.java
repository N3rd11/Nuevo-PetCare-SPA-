package com.petcare.mascota.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.mascota.model.Mascota;
import com.petcare.mascota.repository.MascotaRepository;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository repository;

    public List<Mascota> listar() {
        return repository.findAll();
    }

    public Optional<Mascota> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Mascota guardar(Mascota mascota) {
        return repository.save(mascota);
    }

    public Mascota actualizar(Long id, Mascota mascota) {
        return repository.findById(id).map(m -> {
            m.setNombre(mascota.getNombre());
            m.setGenero(mascota.getGenero());
            m.setUsuarioId(mascota.getUsuarioId());
            m.setEspecieId(mascota.getEspecieId());
            m.setRazaId(mascota.getRazaId());
            return repository.save(m);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public List<Mascota> buscarPorUsuarioId(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

}
