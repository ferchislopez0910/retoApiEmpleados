package com.kruger.apiempleados.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kruger.apiempleados.model.entity.Empleado;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	List<Empleado> findByTieneVacuna(boolean tieneVacuna);
	
}
