package com.metaenlace.formacion.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.metaenlace.formacion.model.Medico;
import com.metaenlace.formacion.model.Usuario;

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
	private Medico medico;
	private Usuario usuario;
	private String nnss;	
	private String numTarjeta;	
	private String telefono;
	private String observaciones;
	private LocalDate fecCreacion;
	private LocalDate fecModificacion;
}
