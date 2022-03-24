package com.kruger.apiempleados.services;

import java.util.List;
import java.util.Optional;

import com.kruger.apiempleados.model.entity.Empleado;

public interface EmpleadoServiceInterface {
	Empleado createEmployee(Empleado employee);
	List<Empleado> listEmployees();
	List<Empleado> listEmployeesByStatus(boolean status);
	Optional<Empleado> listEmployee(Long cedula);
	Empleado updateEmployee(Empleado employee);
	void deleteEmployee(Long cedula);
}
