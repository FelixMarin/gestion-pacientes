package com.metaenlace.formacion.dto;

import org.springframework.stereotype.Component;

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
	private String motivoCita;
}
