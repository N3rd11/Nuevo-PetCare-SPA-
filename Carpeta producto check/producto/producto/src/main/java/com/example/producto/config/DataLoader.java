package com.example.producto.config;

import com.example.producto.model.Producto;
import com.example.producto.repository.productoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private productoRepository ProductoRepository;

    @Override
    public void run(String... args) {
        if (ProductoRepository.count() == 0) {
            Producto p1 = new Producto();
            p1.setNombreProducto("Shampoo Canino");
            ProductoRepository.save(p1);

            Producto p2 = new Producto();
            p2.setNombreProducto("Antipulgas");
            ProductoRepository.save(p2);

            System.out.println("Productos precargados: Shampoo Canino, Antipulgas");
        }
    }
}
