package com.metaenlace.formacion.dto;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.metaenlace.formacion.model.Medico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDto {

	private Long id;
	private String nnss;	
	private String numTarjeta;	
	private String telefono;
	private Set<Medico> linkedPacientes;
}
