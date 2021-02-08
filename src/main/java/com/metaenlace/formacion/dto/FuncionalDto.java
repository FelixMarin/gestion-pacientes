package com.metaenlace.formacion.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.metaenlace.formacion.model.RolFuncional;
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
public class FuncionalDto {

	private Long id;
	private Usuario usuario;
	private RolFuncional rol;
	private String clave;
	private LocalDate fecCreacion;
	private LocalDate fecModificacion;
}
