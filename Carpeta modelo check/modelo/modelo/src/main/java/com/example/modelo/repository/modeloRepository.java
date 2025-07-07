package com.example.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.modelo.model.modelo;

@Repository
public interface modeloRepository extends JpaRepository<modelo,Long>{

}
