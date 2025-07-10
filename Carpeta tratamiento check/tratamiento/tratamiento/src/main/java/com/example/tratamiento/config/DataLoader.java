package com.example.tratamiento.config;


import com.example.tratamiento.model.Tratamiento;
import com.example.tratamiento.repository.tratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private tratamientoRepository TratamientoRepository;

    @Override
    public void run(String... args) {
        if (TratamientoRepository.count() == 0) {
            Tratamiento t1 = new Tratamiento();
            t1.setNombreTratamiento("Desparasitación");
            TratamientoRepository.save(t1);

            Tratamiento t2 = new Tratamiento();
            t2.setNombreTratamiento("Vitaminas");
            TratamientoRepository.save(t2);

            System.out.println("Tratamientos precargados: Desparasitación, Vitaminas");
        }
    }
}

