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
@Table(name="rol_funcional", schema = "salud")
@NamedQuery(name="RolFuncional.findAll", query="SELECT t FROM RolFuncional t")
public class RolFuncional {

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(columnDefinition = "bpchar(255)", length = 255)
	private String descripcion;
	
	@Column(name = "fecha_creacion")
	private LocalDate fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private LocalDate fechaModificacion;
}
