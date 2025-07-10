package com.petcare.resena.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.petcare.resena.dto.ServicioDTO;

@FeignClient(name = "servicio", url = "http://localhost:8087/api/servicios")
public interface ServicioClient {
    @GetMapping("/{id}")
    ServicioDTO obtenerServicio(@PathVariable Long id);
}
