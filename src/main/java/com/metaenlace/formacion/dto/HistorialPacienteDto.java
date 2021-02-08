package com.metaenlace.formacion.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

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
public class HistorialPacienteDto {

	private Long id;
	private Paciente paciente;
	private String historial;
	private LocalDate fecCreacion;
	private LocalDate fecModificacion;
}
