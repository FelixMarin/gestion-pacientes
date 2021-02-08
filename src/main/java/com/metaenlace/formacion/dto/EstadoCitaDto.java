package com.metaenlace.formacion.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoCitaDto {

	private Long id;
	private String nombre;
	private LocalDate fecCreacion;
	private LocalDate fecModificacion;
}
