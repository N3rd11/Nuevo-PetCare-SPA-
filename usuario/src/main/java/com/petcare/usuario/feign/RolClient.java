package com.petcare.usuario.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.petcare.usuario.dto.RolDTO;

@FeignClient(name = "rol", url = "http://localhost:8088/api/roles")
public interface RolClient { 
    @GetMapping("/{id}")
    RolDTO obtenerRolPorId(@PathVariable("id")Long id);

}
