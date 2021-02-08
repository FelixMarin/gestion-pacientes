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
@Table(name="medicacion", schema = "salud")
@NamedQuery(name="Medicacion.findAll", query="SELECT t FROM Medicacion t")
public class Medicacion {

	@Id
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_paciente", referencedColumnName = "id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "id_diagnostico", referencedColumnName = "id")
	private Diagnostico diagnostico;
	
	@Column(columnDefinition = "bpchar(255)", length = 255)
	private String nombre;
	
	private Integer frecuencia;
	
	private Integer cantidad;
	
	@Column(name = "fec_ini")
	private LocalDate fecIni;
	
	@Column(name = "fec_fin")
	private LocalDate fecFin;
	
	@Column(columnDefinition = "bpchar(255)", length = 255)
	private String alergico;
	
	@Column(name = "fecha_creacion")
	private LocalDate fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private LocalDate fechaModificacion;
}
