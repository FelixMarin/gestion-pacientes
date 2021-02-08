package com.metaenlace.formacion.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@IdClass(MedicoPaciente.class)
@Table(name="medico_paciente", schema = "salud")
@NamedQuery(name="MedicoPaciente.findAll", query="SELECT t FROM MedicoPaciente t")
public class MedicoPaciente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_paciente", referencedColumnName = "id")
	private Paciente paciente;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "id_medico", referencedColumnName = "id")	
	private Medico medico;
	
	@Column(name = "fecha_creacion")
	private LocalDate fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private LocalDate fechaModificacion;
}
