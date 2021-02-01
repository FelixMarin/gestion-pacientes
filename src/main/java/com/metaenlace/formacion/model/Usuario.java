package com.metaenlace.formacion.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Data
@NoArgsConstructor
@Table(name="usuario", schema = "salud")
@DiscriminatorColumn(name="tipo_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

	@Id
	@Column(name = "id")
	private Long id;
	
	private String nombre;
	private String apellidos;
	private String usuario;
	private String clave;
	
}
