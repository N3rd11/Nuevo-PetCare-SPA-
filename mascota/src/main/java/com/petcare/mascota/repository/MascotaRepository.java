package com.petcare.mascota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcare.mascota.model.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long>{
List<Mascota> findByUsuarioId(Long usuarioId);
}

