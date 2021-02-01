package com.metaenlace.formacion.dto;

import org.springframework.stereotype.Component;

import com.metaenlace.formacion.model.Cita;

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
	private String valoracionEspecialista;
	private String enfermedad;
	private Cita cita;
}
