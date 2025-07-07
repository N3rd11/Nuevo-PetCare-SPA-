package com.example.servicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.servicios.model.servicios;

@Repository

public interface serviciosRepository extends JpaRepository<servicios,Long>{

}
