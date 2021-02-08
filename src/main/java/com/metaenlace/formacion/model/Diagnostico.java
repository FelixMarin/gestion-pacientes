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
@Table(name="diagnostico", schema = "salud")
@NamedQuery(name="Diagnostico.findAll", query="SELECT t FROM Diagnostico t")
public class Diagnostico {

	@Id
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_cita", referencedColumnName = "id")
	private Cita cita;
	
	@ManyToOne
	@JoinColumn(name = "id_paciente", referencedColumnName = "id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "id_historial", referencedColumnName = "id")
	private HistorialPaciente historial;
		
	@Column(name = "valoracion_especialista", columnDefinition = "bpchar(255)", length = 255)
	private String valoracionEspecialista;
	
	@Column(columnDefinition = "bpchar(255)", length = 255)
	private String enfermedad;
	
	@Column(name = "fecha_creacion")
	private LocalDate fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private LocalDate fechaModificacion;

}
