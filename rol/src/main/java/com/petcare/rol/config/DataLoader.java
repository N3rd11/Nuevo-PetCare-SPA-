package com.petcare.rol.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petcare.rol.model.Rol;
import com.petcare.rol.repository.RolRepository;
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private RolRepository rolRepository;

    @Override
    public void run(String... args) {
        if (rolRepository.count() == 0) {
            Rol admin = new Rol();
            admin.setNombre("Administrador");
            rolRepository.save(admin);

            Rol usuario = new Rol();
            usuario.setNombre("Usuario");
            rolRepository.save(usuario);

            System.out.println("Roles precargados: Administrador y Usuario");
        }
    }
}
