package com.petcare.mascota.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.petcare.mascota.dto.RazaDTO;

@FeignClient(name = "raza", url = "http://localhost:8085/api/razas")
public interface RazaClient {
    @GetMapping("/{id}")
    RazaDTO obtenerPorId(@PathVariable Long id);
}
