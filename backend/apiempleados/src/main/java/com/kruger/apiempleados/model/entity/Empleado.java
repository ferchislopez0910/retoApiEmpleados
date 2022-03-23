package com.kruger.apiempleados.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable{

	private static final long serialVersionUID = 1L;

		@Id
		@NotNull(message = "Campo obligatorio")
		@Min(value = 1, message = "La cedula no puede ser inferior a 1")
		@Max(value = 10, message = "La cedula no puede ser superior a 10")
		@Column(unique = true, nullable = false)
		private Long cedula;
		@NotNull(message = "Campo obligatorio")
		@Pattern(regexp = "^[a-zA-Z]")
		@Column(nullable = false)
		private String nombres;
		@NotNull(message = "Campo obligatorio")
		@Pattern(regexp = "^[a-zA-Z]")
		@Column(nullable = false)
		private String apellidos;
		@NotNull(message = "Campo obligatorio")
		@Email(message = "Formato de correo invalido")
		@Column(nullable = false)
		private String email;
		private Date fechaNacimiento;
		private String direccion;
		private String telefono;
}
