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
@DiscriminatorValue("M")
@Getter@Setter
@NoArgsConstructor
@Table(name="medico", schema = "salud")
@NamedQuery(name="Medico.findAll", query="SELECT t FROM Medico t")
public class Medico {

	@Id
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;
	
	@Column(name = "num_colegiado", columnDefinition = "bpchar(255)", length = 255) 
	private String numColegiado;	
	
	@Column(name = "fecha_creacion")
	private LocalDate fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private LocalDate fechaModificacion;
}
