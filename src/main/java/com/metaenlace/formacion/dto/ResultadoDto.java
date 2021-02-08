package com.metaenlace.formacion.dto;

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
public class ResultadoDto {

	private Long id;
	
	private String nombre;
	private String apellidos;
	private String usuario;
	private Medico medicoAsignado;
	private String clave;
	private String nnss;	
	private String numTarjeta;	
	private String telefono;
	private String numColegiado;	
}
