package com.petcare.usuario.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.petcare.usuario.model.Usuario;
import com.petcare.usuario.repository.UsuarioRepository;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) {
        usuarioRepository.deleteAll();

        if (usuarioRepository.count() == 0) {
            Usuario admin = new Usuario();
            admin.setNombrecompleto("Admin");
            admin.setCorreo("admin@mail.com");
            admin.setContrasena(encoder.encode("1234"));
            admin.setTelefono("987654321");
            admin.setRolId(1L);
            admin.setEstadoId(1L);

            usuarioRepository.save(admin);
            System.out.println("Usuario admin precargado.");
        }
    }
}
