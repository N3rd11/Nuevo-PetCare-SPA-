package com.example.producto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producto.model.Producto;
import com.example.producto.repository.productoRepository;

@Service

public class ProductoService {

    @Autowired
    private productoRepository ProductoRepository;

    // Obtener todos los productos
    public List<Producto> getProductos() {
        return ProductoRepository.findAll();
    }

    // Obtener un producto por ID
    public Producto getProducto(Long id) {
        return ProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    // Crear un nuevo producto
    public Producto saveProducto(Producto nuevo) {
        return ProductoRepository.save(nuevo);
    }

    // Actualizar un producto existente
    public Producto updateProducto(Long id, Producto actualizado) {
        Producto existente = ProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        existente.setNombreProducto(actualizado.getNombreProducto());
        existente.setDescripcion(actualizado.getDescripcion());
        return ProductoRepository.save(existente);
    }

    // Eliminar un producto
    public void deleteProducto(Long id) {
        ProductoRepository.deleteById(id);
    }
}
