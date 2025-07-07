package com.petcare.ubicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.ubicacion.model.Region;
import com.petcare.ubicacion.repository.RegionRepository;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepo;

    public List<Region> listarRegiones(){
        return regionRepo.findAll();
    }
    public Region guardarRegion(Region region) {
        return regionRepo.save(region);
    }
    public Optional<Region> buscarRegionPorId(Long id) {
        return regionRepo.findById(id);
    }
    public void eliminarRegion(Long id) {
        regionRepo.deleteById(id);
    }
}
