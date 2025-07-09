package com.petcare.usuario.service;

import com.petcare.usuario.model.Usuario;
import com.petcare.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public Usuario registrar(Usuario usuario) {
        if (usuario.getContrasena() == null || usuario.getContrasena().isBlank()) {
            throw new IllegalArgumentException("La contraseña no puede ser vacía");
        }

        usuario.setContrasena(encoder.encode(usuario.getContrasena()));
        return repository.save(usuario);
    }

    public Optional<Usuario> login(String correo, String contrasena) {
        if (correo == null || contrasena == null) {
            return Optional.empty();
        }

        Optional<Usuario> usuario = repository.findByCorreo(correo);
        if (usuario.isPresent() && encoder.matches(contrasena, usuario.get().getContrasena())) {
            return usuario;
        }

        return Optional.empty();
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Usuario actualizar(Long id, Usuario datos) {
        Optional<Usuario> op = repository.findById(id);
        if (op.isPresent()) {
            Usuario u = op.get();
            u.setNombrecompleto(datos.getNombrecompleto());
            u.setCorreo(datos.getCorreo());
            u.setTelefono(datos.getTelefono());
            u.setRolId(datos.getRolId());
            u.setEstadoId(datos.getEstadoId());

            if (datos.getContrasena() != null && !datos.getContrasena().isBlank()) {
                u.setContrasena(encoder.encode(datos.getContrasena()));
            }

            return repository.save(u);
        }
        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

