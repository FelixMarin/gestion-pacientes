package com.metaenlace.formacion.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("M")
@Getter@Setter
@NoArgsConstructor
@Table(name="medico", schema = "salud")
public class Medico extends Usuario {

	@Column(name = "num_colegiado")
	private String numColegiado;	
	
	@ManyToMany
	@JoinTable(
	  name = "medico_paciente", 
	  joinColumns = @JoinColumn(name = "id_medico"), 
	  inverseJoinColumns = @JoinColumn(name = "id_paciente"))
	private Set<Paciente> linkedPacientes;
}
