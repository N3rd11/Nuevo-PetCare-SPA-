package com.petcare.ubicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcare.ubicacion.model.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {

}
