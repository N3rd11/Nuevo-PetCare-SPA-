package com.petcare.ubicacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.ubicacion.model.Comuna;
import com.petcare.ubicacion.model.Direccion;
import com.petcare.ubicacion.model.Region;
import com.petcare.ubicacion.service.ComunaService;
import com.petcare.ubicacion.service.DireccionService;
import com.petcare.ubicacion.service.RegionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/ubicacion")
@Tag(name = "Ubicacion", description = "CRUD de Región, Comuna y Dirección")
public class UbicacionController {
    @Autowired private RegionService regionService;
    @Autowired private ComunaService comunaService;
    @Autowired private DireccionService direccionService;

    // REGION ------------------------
    @GetMapping("/regiones")
    @Operation(summary = "Listar regiones")
    public List<Region> getRegiones() {
        return regionService.listarRegiones();
    }

    @PostMapping("/regiones")
    @Operation(summary = "Crear nueva región")
    public Region createRegion(@RequestBody Region region) {
        return regionService.guardarRegion(region);
    }

    @GetMapping("/regiones/{id}")
    @Operation(summary = "Obtener región por ID")
    public Region getRegionById(@PathVariable Long id) {
        return regionService.buscarRegionPorId(id).orElse(null);
    }

    @DeleteMapping("/regiones/{id}")
    @Operation(summary = "Eliminar región")
    public void deleteRegion(@PathVariable Long id) {
        regionService.eliminarRegion(id);
    }

    // COMUNA ------------------------
    @GetMapping("/comunas")
    @Operation(summary = "Listar comunas")
    public List<Comuna> getComunas() {
        return comunaService.listarComunas();
    }

    @PostMapping("/comunas")
    @Operation(summary = "Crear nueva comuna")
    public Comuna createComuna(@RequestBody Comuna comuna) {
        return comunaService.guardarComuna(comuna);
    }

    @GetMapping("/comunas/{id}")
    @Operation(summary = "Obtener comuna por ID")
    public Comuna getComunaById(@PathVariable Long id) {
        return comunaService.buscarComunaPorId(id).orElse(null);
    }

    @DeleteMapping("/comunas/{id}")
    @Operation(summary = "Eliminar comuna")
    public void deleteComuna(@PathVariable Long id) {
        comunaService.eliminarComuna(id);
    }

    // DIRECCION ---------------------
    @GetMapping("/direcciones")
    @Operation(summary = "Listar direcciones")
    public List<Direccion> getDirecciones() {
        return direccionService.listarDirecciones();
    }

    @PostMapping("/direcciones")
    @Operation(summary = "Crear nueva dirección")
    public Direccion createDireccion(@RequestBody Direccion direccion) {
        return direccionService.guardarDireccion(direccion);
    }

    @GetMapping("/direcciones/{id}")
    @Operation(summary = "Obtener dirección por ID")
    public Direccion getDireccionById(@PathVariable Long id) {
        return direccionService.buscarDireccionPorId(id);
    }

    @DeleteMapping("/direcciones/{id}")
    @Operation(summary = "Eliminar dirección")
    public void deleteDireccion(@PathVariable Long id) {
        direccionService.eliminarDireccion(id);
    }

    @GetMapping("/direcciones/usuario/{usuarioId}")
    @Operation(summary = "Obtener direcciones por ID de usuario")
    public List<Direccion> getDireccionesByUsuario(@PathVariable Long usuarioId) {
        return direccionService.listarPorUsuarioId(usuarioId);
    }
}
