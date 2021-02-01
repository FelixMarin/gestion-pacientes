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
@Table(name="diagnostico", schema = "salud")
@NamedQuery(name="Diagnostico.findAll", query="SELECT t FROM Diagnostico t")
public class Diagnostico {

	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "valoracion_especialista")
	private String valoracionEspecialista;
	private String enfermedad;
	
	@ManyToOne
	@JoinColumn(name = "id_cita", referencedColumnName = "id")
	private Cita cita;
}
