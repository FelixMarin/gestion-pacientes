package com.metaenlace.formacion.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.metaenlace.formacion.model.EstadoCita;
import com.metaenlace.formacion.model.HistorialPaciente;
import com.metaenlace.formacion.model.Medico;
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
public class CitaDto {

	private Long id;
	private Paciente paciente;
	private Medico medico;
	private HistorialPaciente historial;
	private EstadoCita estado;
	private String motivoCita;
	private LocalDate fecHoraCita;
	private LocalDate fecCreacion;
	private LocalDate fecModificacion;
}
