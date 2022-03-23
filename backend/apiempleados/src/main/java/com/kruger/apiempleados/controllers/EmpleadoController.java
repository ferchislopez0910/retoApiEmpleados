package com.kruger.apiempleados.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.apiempleados.exceptions.EmpleadoNoEncontradoExcepcion;
import com.kruger.apiempleados.model.entity.Empleado;
import com.kruger.apiempleados.services.EmpleadoServiceInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
/**
 * 
 * @author MariaF
 *
 */

@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {
	@Autowired
	private EmpleadoServiceInterface emplService;
	
	
	@PostMapping()
	@Operation(summary="Crear empleado", description="Crear empleado en el sistema", tags= {"Empleado"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Success - Empleado creado",
					content = {@Content(mediaType = "application/json",
					schema = @Schema(implementation = Empleado.class))}),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
		    @ApiResponse(responseCode = "404", description = " Page Not Found", content = @Content)})
	@ResponseBody
	public Empleado crearEmpleado(@Valid @RequestBody Empleado employee) {
		return emplService.createEmployee(employee);
		
	}
	
	@GetMapping()
	@Operation(summary="Consultar lista de empleado", description="Consultar lista de empleados registrado en el sistema", tags= {"Empleado"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = {@Content(mediaType = "application/json",
					schema = @Schema(implementation = Empleado.class))}),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
		    @ApiResponse(responseCode = "404", description = " Page Not Found", content = @Content)})
	@ResponseBody
	public List<Empleado> consultarEmpleados() {
		return emplService.listEmployees();
		
	}
	
	@GetMapping("/{id}")
	@Operation(summary="Consultar empleado", description="Obtener empleado registrado en el sistema", tags= {"Empleado"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = {@Content(mediaType = "application/json",
					schema = @Schema(implementation = Empleado.class))}),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
		    @ApiResponse(responseCode = "404", description = " Page Not Found", content = @Content)})
	@ResponseBody
	public Empleado consultaEmpleadoPorCedula(@PathVariable("id") @Min(1) Long id) {
		Empleado empleado = emplService.listEmployee(id).orElseThrow(()-> new EmpleadoNoEncontradoExcepcion("Empleado no encontrado con el id: " + id));
		return empleado;
	}
	
	@PutMapping("/{id}")
	@Operation(summary="Actualizar empleado", description="Actualizar empleado registrado en el sistema", tags= {"Empleado"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = {@Content(mediaType = "application/json",
					schema = @Schema(implementation = Empleado.class))}),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
		    @ApiResponse(responseCode = "404", description = " Page Not Found", content = @Content)})
	@ResponseBody
	public Empleado actualizarEmpleado(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Empleado employee) {
		emplService.listEmployee(id).orElseThrow(()-> new EmpleadoNoEncontradoExcepcion("Empleado no encontrado con el id: " + id));
		return emplService.updateEmployee(employee);
	}

	@DeleteMapping("/{id}")
	@Operation(summary="Eliminar empleado", description="Eliminiar empleado en el sistema", tags= {"Empleado"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success - Empleado eliminado",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
		    @ApiResponse(responseCode = "404", description = " Page Not Found", content = @Content)})
	@ResponseBody
	public void eliminarEmpleado(@PathVariable("id") @Min(1) Long id) {
		emplService.listEmployee(id).orElseThrow(()-> new EmpleadoNoEncontradoExcepcion("Empleado no encontrado con el id: " + id));
		emplService.deleteEmployee(id);
		
	}
}
