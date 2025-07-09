package com.petcare.usuario.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.petcare.usuario.model.Usuario;
import com.petcare.usuario.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "Crud usuarios")  
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/registro")
    @Operation(summary = "Registrar nuevo usuario")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return service.registrar(usuario);
    }

    @PostMapping("/login")
    @Operation(summary = "Login de usuario")
    public Map<String, Object> login(@RequestBody Map<String, String> datos) {
        Map<String, Object> response = new HashMap<>();

        if (datos.get("correo") == null || datos.get("contrasena") == null) {
            response.put("mensaje", "Faltan datos: correo o contraseña");
            return response;
        }

        String correo = datos.get("correo");
        String contrasena = datos.get("contrasena");

        Optional<Usuario> usuario = service.login(correo, contrasena);
        if (usuario.isPresent()) {
            response.put("mensaje", "Login exitoso");
            response.put("usuario", usuario.get());
        } else {
            response.put("mensaje", "Credenciales inválidas");
        }

        return response;
    }

    @GetMapping
    @Operation(summary = "Listar todos los usuarios")
    public List<Usuario> listar() {
        return service.listar();
    }
}