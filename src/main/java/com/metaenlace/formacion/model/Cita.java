package com.metaenlace.formacion.model;

import java.time.LocalDate;

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
	
	@ManyToOne
	@JoinColumn(name = "id_historial", referencedColumnName = "id")
	private HistorialPaciente historial;
	
	@ManyToOne
	@JoinColumn(name = "id_estado", referencedColumnName = "id")
	private EstadoCita estado;
	
	@Column(name = "motivo_cita", columnDefinition = "bpchar(255)", length = 255) 
	private String motivoCita;
	
	@Column(name = "fecha_hora_cita")
	private LocalDate fechaHoraCita;
	
	@Column(name = "fecha_creacion")
	private LocalDate fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private LocalDate fechaModificacion;
}
