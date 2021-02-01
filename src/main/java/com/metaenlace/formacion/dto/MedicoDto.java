package com.metaenlace.formacion.dto;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.metaenlace.formacion.model.Paciente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDto {
	
	private Long id;
	private String numColegiado;	
	private Set<Paciente> linkedPacientes;

}
