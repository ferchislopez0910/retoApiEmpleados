package com.kruger.apiempleados.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kruger.apiempleados.model.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	
}
