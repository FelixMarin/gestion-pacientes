package com.metaenlace.formacion.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.metaenlace.formacion.model.Usuario;

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
	private Usuario usuario;
	private String numColegiado;	
	private LocalDate fecCreacion;
	private LocalDate fecModificacion;

}
