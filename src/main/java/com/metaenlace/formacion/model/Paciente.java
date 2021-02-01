package com.metaenlace.formacion.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("P")
@Getter@Setter
@NoArgsConstructor
@Table(name="paciente", schema = "salud")
public class Paciente extends Usuario {

	private String nnss;	
	@Column(name = "num_tarjeta")
	private String numTarjeta;	
	private String telefono;
	
	@ManyToMany(mappedBy = "linkedPacientes")
	private Set<Medico> linkedPacientes;
}
