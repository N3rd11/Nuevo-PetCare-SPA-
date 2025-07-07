package com.example.historial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.historial.model.historial;

@Repository

public interface historialRepository extends JpaRepository<historial,Long>{
    List<historial> findByMascotaId(Long mascotaId);

}
