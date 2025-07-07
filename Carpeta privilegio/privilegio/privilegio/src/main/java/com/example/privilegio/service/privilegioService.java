package com.example.privilegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.privilegio.model.privilegio;
import com.example.privilegio.repository.privilegioRepository;

@Service
public class privilegioService {

     @Autowired
    private privilegioRepository PrivilegioRepository;

    public List<privilegio> getPrivilegios() {
        return PrivilegioRepository.findAll();
    }

    public privilegio getPrivilegio(Long id) {
        return PrivilegioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Privilegio no encontrado"));
    }

    public privilegio savePrivilegio(privilegio privilegio) {
        return PrivilegioRepository.save(privilegio);
    }

    public privilegio updatePrivilegio(Long id, privilegio privilegioActualizado) {
        privilegio existente = getPrivilegio(id);
        existente.setNombre(privilegioActualizado.getNombre());
        existente.setDescripcion(privilegioActualizado.getDescripcion());
        return PrivilegioRepository.save(existente);
    }

    public void deletePrivilegio(Long id) {
        PrivilegioRepository.deleteById(id);
    }
}
