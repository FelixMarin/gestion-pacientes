package com.metaenlace.formacion.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("F")
@Setter@Getter
@NoArgsConstructor
@Table(name="funcional", schema = "salud")
@NamedQuery(name="Funcional.findAll", query="SELECT t FROM Funcional t")
public class Funcional {
	
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_rol", referencedColumnName = "id")
	private RolFuncional rolFuncional;
	
	@Column(columnDefinition = "bpchar(255)", length = 255) 
	private String clave;
	
	@Column(name = "fecha_creacion")
	private LocalDate fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private LocalDate fechaModificacion;

}
