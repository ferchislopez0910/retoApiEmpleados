package com.kruger.apiempleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kruger.apiempleados.model.entity.Vacunacion;


@Repository
public interface VacunacionRepository extends JpaRepository<Vacunacion, Long>{
	

}
