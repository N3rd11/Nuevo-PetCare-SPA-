package com.example.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reserva.model.reserva;

@Repository

public interface reservaRepository extends JpaRepository<reserva,Long>{

}
