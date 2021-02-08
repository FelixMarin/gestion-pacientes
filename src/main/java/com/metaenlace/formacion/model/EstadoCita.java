package com.metaenlace.formacion.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Data
@NoArgsConstructor
@Table(name="estado_cita", schema = "salud")
@NamedQuery(name="EstadoCita.findAll", query="SELECT t FROM EstadoCita t")
public class EstadoCita {

	@Id
	@Column(name = "id")
	private Long id;
		
	private String nombre;
	
	@Column(name = "fecha_creacion")
	private LocalDate fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private LocalDate fechaModificacion;
}
