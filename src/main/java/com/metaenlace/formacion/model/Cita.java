package com.metaenlace.formacion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Data
@NoArgsConstructor
@Table(name="cita", schema = "salud")
@NamedQuery(name="Cita.findAll", query="SELECT t FROM Cita t")
public class Cita {

	@Id
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_paciente", referencedColumnName = "id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "id_medico", referencedColumnName = "id")
	private Medico medico;
	
	@Column(name = "motivo_cita")
	private String motivoCita;
}
