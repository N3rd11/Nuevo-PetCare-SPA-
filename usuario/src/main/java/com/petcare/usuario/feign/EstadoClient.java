package com.petcare.usuario.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.petcare.usuario.dto.EstadoDTO;

@FeignClient(name = "estado", url = "http://localhost:8091/api/v1/estado")
public interface EstadoClient {
    @GetMapping("/{id}")
    EstadoDTO obtenerEstadoPorId(@PathVariable("id") Long id);
}

