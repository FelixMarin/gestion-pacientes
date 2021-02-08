package com.metaenlace.formacion.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("P")
@Getter@Setter
@NoArgsConstructor
@Table(name="paciente", schema = "salud")
@NamedQuery(name="Paciente.findAll", query="SELECT t FROM Paciente t")
public class Paciente {

	@Id
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "id_medico_asignado", referencedColumnName = "id")
	private Medico medico;
	
	@Column(columnDefinition = "bpchar(255)", length = 255) 
	private String nnss;
	
	@Column(name = "num_tarjeta", columnDefinition = "bpchar(255)", length = 255) 
	private String numTarjeta;	
	
	@Column(columnDefinition = "bpchar(255)", length = 255) 
	private String observaciones;
	
	@Column(columnDefinition = "bpchar(255)", length = 255) 
	private String telefono;
	
	@Column(name = "fecha_creacion")
	private LocalDate fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private LocalDate fechaModificacion;
}
