package com.kruger.apiempleados.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vacunacion")
public class Vacunacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	@NotNull(message = "Campo obligatorio")
	@Column(nullable = false)
	private String tipoVacuna;
	@NotNull(message = "Campo obligatorio")
	@Column(nullable = false)
	private Date fechaVacuna;
	@NotNull(message = "Campo obligatorio")
	@Column(nullable = false)
	private int numeroDosis;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cedula")
    @JsonBackReference
    private Empleado empleado;
}
