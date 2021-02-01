package com.metaenlace.formacion.dto;

import java.util.Set;

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
public class ResultadoDto {

	private Long id;
	
	private String nombre;
	private String apellidos;
	private String usuario;
	private String clave;
	private String nnss;	
	private String numTarjeta;	
	private String telefono;
	private Set<Medico> linkedMedicos;
	private Set<Paciente> linkedPacientes;
	private String numColegiado;	
}
