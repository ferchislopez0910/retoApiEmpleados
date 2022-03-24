package com.kruger.apiempleados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.apiempleados.common.Util;
import com.kruger.apiempleados.model.entity.Empleado;
import com.kruger.apiempleados.model.entity.Vacunacion;
import com.kruger.apiempleados.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements EmpleadoServiceInterface{
	
	EmpleadoRepository empRepository;
	@Autowired
	public EmpleadoService(EmpleadoRepository emp) {
		this.empRepository = emp;
	}

	
	@Override
	public Empleado createEmployee(Empleado employee) {
		String contrasena = Util.createPassword(employee.getApellidos());
		employee.setUsuario(employee.getEmail());
		employee.setContrasena(contrasena);
		return empRepository.save(employee);
	}

	
	@Override
	public List<Empleado> listEmployees() {
		return empRepository.findAll();
	}

	

	@Override
	public Empleado updateEmployee(Empleado employee) {
		Vacunacion vacuna = employee.getVacunacion();
		if(vacuna != null && vacuna.getId() > 0)
			employee.setVacunacion(vacuna);
		return empRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long cedula) {
		empRepository.deleteById(cedula);
		
	}

	@Override
	public Optional<Empleado> listEmployee(Long cedula) {
		return empRepository.findById(cedula);
	}


	@Override
	public List<Empleado> listEmployeesByStatus(boolean status) {
		return empRepository.findByTieneVacuna(status);
	}

}
