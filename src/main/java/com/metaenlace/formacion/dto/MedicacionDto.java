package com.metaenlace.formacion.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.metaenlace.formacion.model.Diagnostico;
import com.metaenlace.formacion.model.Paciente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicacionDto {

	private Long id;
	private Paciente paciente;
	private Diagnostico diagnostico;
	private String nombre;
	private Integer frecuencia;
	private Integer cantidad;
	private String alergico;
	private LocalDate fecIni;
	private LocalDate fecFin;
	private LocalDate fecCreacion;
	private LocalDate fecModificacion;
}
