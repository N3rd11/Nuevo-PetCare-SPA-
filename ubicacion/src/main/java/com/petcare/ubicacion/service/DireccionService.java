package com.petcare.ubicacion.service;
import com.petcare.ubicacion.model.Direccion;
import com.petcare.ubicacion.repository.DireccionRepository;
import com.petcare.ubicacion.feign.*;
import com.petcare.ubicacion.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    public List<Direccion> listarDirecciones() {
        return direccionRepository.findAll();
    }

    public Direccion guardarDireccion(Direccion direccion) {
        // Validar existencia de usuario antes de guardar
       UsuarioDTO usuario = usuarioClient.obtenerPorId(direccion.getUsuarioId());

        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado para ID: " + direccion.getUsuarioId());
        }
        return direccionRepository.save(direccion);
    }

    public Direccion buscarDireccionPorId(Long id) {
        return direccionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dirección no encontrada con ID: " + id));
    }

    public void eliminarDireccion(Long id) {
        if (!direccionRepository.existsById(id)) {
            throw new RuntimeException("No existe dirección con ID: " + id);
        }
        direccionRepository.deleteById(id);
    }

    public List<Direccion> listarPorUsuarioId(Long usuarioId) {
        return direccionRepository.findByUsuarioId(usuarioId);
    }
}
