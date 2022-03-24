package com.kruger.apiempleados.services;

import java.util.List;

import com.kruger.apiempleados.model.dto.FiltroVacunacion;
import com.kruger.apiempleados.model.entity.Vacunacion;

public interface VacunacionServiceInterface {
	List<Vacunacion> listarEmpleadosVacunados(FiltroVacunacion filtro);

}
