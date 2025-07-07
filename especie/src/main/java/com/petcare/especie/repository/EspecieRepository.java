package com.petcare.especie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcare.especie.model.Especie;

public interface EspecieRepository extends JpaRepository <Especie, Long> {

}
