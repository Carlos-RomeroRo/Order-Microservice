package com.UniversidadDelMagdalena.Orden.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UniversidadDelMagdalena.Orden.Entities.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Long> {

}
