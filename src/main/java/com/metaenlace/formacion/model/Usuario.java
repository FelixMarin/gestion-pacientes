package com.metaenlace.formacion.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name="usuario", schema = "salud")
@NamedQuery(name="Usuario.findAll", query="SELECT t FROM Usuario t")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = -8394505569574671400L;

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(columnDefinition = "bpchar(255)", length = 255) 
	private String nombre;
	
	@Column(columnDefinition = "bpchar(255)", length = 255) 
	private String apellidos;
	
	@Column(columnDefinition = "bpchar(255)", length = 255) 
	private String login;
	
	@Column(name = "tipo_usuario", columnDefinition = "bpchar(255)", length = 255) 
	private String tipoUsuario;
	
	@Column(columnDefinition = "bpchar(255)", length = 255) 
	private String clave;
	
	@Column(name = "fecha_creacion")
	private LocalDate fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private LocalDate fechaModificacion;
	
}
