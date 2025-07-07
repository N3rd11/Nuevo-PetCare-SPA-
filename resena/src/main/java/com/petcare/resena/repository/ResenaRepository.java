package com.petcare.resena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcare.resena.model.Resena;

public interface ResenaRepository extends JpaRepository<Resena, Long>{
    List<Resena> findByUsuarioId(Long usuarioId);

}
