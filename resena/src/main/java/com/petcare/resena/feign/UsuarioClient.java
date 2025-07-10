package com.petcare.resena.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.petcare.resena.dto.UsuarioDTO;

@FeignClient(name = "usuario", url = "http://localhost:8081/api/usuarios")
public interface UsuarioClient {
    @GetMapping("/{id}")
    UsuarioDTO obtenerUsuario(@PathVariable Long id);
}
