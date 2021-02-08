package com.metaenlace.formacion.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.metaenlace.formacion.model.Cita;
import com.metaenlace.formacion.model.HistorialPaciente;
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
public class DiagnosticoDto {
	
	private Long id;
	private Cita cita;	
	private Paciente paciente;
	private HistorialPaciente historial;
	private String valoracionEspecialista;
	private String enfermedad;
	private LocalDate fecCreacion;
	private LocalDate fecModificacion;
}
