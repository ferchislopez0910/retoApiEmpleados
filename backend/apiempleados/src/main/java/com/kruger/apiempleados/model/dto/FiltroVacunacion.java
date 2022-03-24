package com.kruger.apiempleados.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiltroVacunacion {

	private String estado;
	private String tipo;
}
