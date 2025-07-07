package com.example.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.producto.model.Producto;

@Repository

public interface productoRepository extends JpaRepository<Producto,Long> {

}
