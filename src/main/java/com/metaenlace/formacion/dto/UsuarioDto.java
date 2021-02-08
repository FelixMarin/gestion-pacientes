package com.metaenlace.formacion.dto;

import java.io.Serializable;
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
public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public UsuarioDto(String namelogin, String clave) {
		this.namelogin = namelogin;
		this.clave = clave;
	}
	
	private Long id;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String namelogin;
	private String tipoUsuario;
	private String clave;
	private LocalDate fecCreacion;
	private LocalDate fecModificacion;
}
