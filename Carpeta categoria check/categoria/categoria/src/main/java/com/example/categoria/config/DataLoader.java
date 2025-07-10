package com.example.categoria.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.example.categoria.model.categoria;
import com.example.categoria.repository.categoriaRepository;


@Configuration
public class DataLoader implements CommandLineRunner {

    private final categoriaRepository CategoriaRepository;

    public DataLoader(categoriaRepository categoriaRepository) {
        this.CategoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (CategoriaRepository.count() == 0) {
            CategoriaRepository.save(new categoria(10, "Baño"));
            CategoriaRepository.save(new categoria(20, "Peluquería"));
            CategoriaRepository.save(new categoria(30, "Consulta"));
        }
    }

}
