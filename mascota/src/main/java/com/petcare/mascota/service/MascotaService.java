package com.petcare.mascota.service;

import com.petcare.mascota.dto.EspecieDTO;
import com.petcare.mascota.dto.RazaDTO;
import com.petcare.mascota.dto.UsuarioDTO;
import com.petcare.mascota.feign.EspecieClient;
import com.petcare.mascota.feign.RazaClient;
import com.petcare.mascota.feign.UsuarioClient;
import com.petcare.mascota.model.Mascota;
import com.petcare.mascota.repository.MascotaRepository;

import feign.FeignException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private RazaClient razaClient;

    @Autowired
    private EspecieClient especieClient;

    public Mascota registrar(Mascota mascota) {
        try {
            // 🔎 Mostrar valores recibidos
            System.out.println("➡ Registrando nueva mascota:");
            System.out.println("Nombre: " + mascota.getNombre());
            System.out.println("Género: " + mascota.getGenero());
            System.out.println("Usuario ID: " + mascota.getUsuarioId());
            System.out.println("Raza ID: " + mascota.getRazaId());
            System.out.println("Especie ID: " + mascota.getEspecieId());

            // ✅ Validar que los IDs existan en los otros microservicios
            UsuarioDTO usuario = usuarioClient.obtenerPorId(mascota.getUsuarioId());
            RazaDTO raza = razaClient.obtenerPorId(mascota.getRazaId());
            EspecieDTO especie = especieClient.obtenerPorId(mascota.getEspecieId());

            System.out.println("✅ Usuario encontrado: " + usuario.getNombrecompleto());
            System.out.println("✅ Raza encontrada: " + raza.getNombre());
            System.out.println("✅ Especie encontrada: " + especie.getNombre());

            // 💾 Guardar mascota
            return mascotaRepository.save(mascota);

        } catch (FeignException.NotFound e) {
            System.err.println("❌ ID no encontrado: " + e.getMessage());
            throw new RuntimeException("Alguno de los IDs no existe en otro microservicio");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Error inesperado al registrar mascota: " + e.getMessage());
        }
    }

    public List<Mascota> listar() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> obtenerPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    public Mascota actualizar(Long id, Mascota datos) {
        Optional<Mascota> op = mascotaRepository.findById(id);
        if (op.isPresent()) {
            Mascota m = op.get();
            m.setNombre(datos.getNombre());
            m.setGenero(datos.getGenero());
            m.setUsuarioId(datos.getUsuarioId());
            m.setEspecieId(datos.getEspecieId());
            m.setRazaId(datos.getRazaId());
            return mascotaRepository.save(m);
        }
        return null;
    }

    public void eliminar(Long id) {
        mascotaRepository.deleteById(id);
    }

    public List<Mascota> buscarPorUsuarioId(Long usuarioId) {
        return mascotaRepository.findByUsuarioId(usuarioId);
    }
}
