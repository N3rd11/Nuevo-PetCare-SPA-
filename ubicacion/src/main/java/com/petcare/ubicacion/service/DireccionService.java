package com.petcare.ubicacion.service;
import com.petcare.ubicacion.model.Direccion;
import com.petcare.ubicacion.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    public List<Direccion> listarDirecciones() {
        return direccionRepository.findAll();
    }

    public Direccion guardarDireccion(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public Direccion buscarDireccionPorId(Long id) {
        return direccionRepository.findById(id).orElse(null);
    }

    public void eliminarDireccion(Long id) {
        direccionRepository.deleteById(id);
    }

    public List<Direccion> listarPorUsuarioId(Long usuarioId) {
        return direccionRepository.findByUsuarioId(usuarioId);
    }
}
