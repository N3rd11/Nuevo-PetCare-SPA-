package com.example.estado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estado.model.estado;

@Repository

public interface estadoRepository extends JpaRepository<estado,Long>{
 
}
