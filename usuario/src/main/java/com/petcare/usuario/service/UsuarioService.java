package com.petcare.usuario.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.petcare.usuario.model.Usuario;
import com.petcare.usuario.repository.UsuarioRepository;
@Service
public class UsuarioService {
@Autowired
private UsuarioRepository repository;

@Autowired
private PasswordEncoder encoder;

public Usuario registrar(Usuario usuario) {
    usuario.setContrasena(encoder.encode(usuario.getContrasena()));
    return repository.save(usuario);
}

public Optional<Usuario> login(String correo, String contrasena) {
    Optional<Usuario> usuario = repository.findByCorreo(correo);
    if (usuario.isPresent() && encoder.matches(contrasena, usuario.get().getContrasena())) {
        return usuario;
    }
    return Optional.empty();
}

public List<Usuario> obtenerTodos() {
    return repository.findAll();
}

public Optional<Usuario> obtenerPorId(Long id) {
    return repository.findById(id);
}

public Usuario actualizar(Long id, Usuario usuario) {
    Optional<Usuario> usuarioExistente = repository.findById(id);
    if (usuarioExistente.isPresent()) {
        Usuario u = usuarioExistente.get();
        u.setNombrecompleto(usuario.getNombrecompleto());
        u.setCorreo(usuario.getCorreo());
        u.setContrasena(encoder.encode(usuario.getContrasena()));
        return repository.save(u);
    }
    return null;
}

    public void eliminar(Long id) {
    repository.deleteById(id);
}
}
