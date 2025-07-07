package com.example.tratamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tratamiento.model.Tratamiento;

@Repository

public interface tratamientoRepository extends JpaRepository<Tratamiento,Long>{

}
