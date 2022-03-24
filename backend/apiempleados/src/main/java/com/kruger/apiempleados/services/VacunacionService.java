package com.kruger.apiempleados.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.apiempleados.model.dto.FiltroVacunacion;
import com.kruger.apiempleados.model.entity.Vacunacion;
import com.kruger.apiempleados.repository.VacunacionRepository;

@Service
public class VacunacionService implements VacunacionServiceInterface {
	@Autowired
	VacunacionRepository vacunaRepo; 
	
	@Override
	public List<Vacunacion> listarEmpleadosVacunados(FiltroVacunacion filtro) {
		
		return null;
	}

}
