package com.petcare.mascota.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.petcare.mascota.dto.EspecieDTO;

@FeignClient(name = "especie", url = "http://localhost:8087/api/especies")
public interface EspecieClient {
    @GetMapping("/{id}")
    EspecieDTO obtenerPorId(@PathVariable Long id);
    
}
