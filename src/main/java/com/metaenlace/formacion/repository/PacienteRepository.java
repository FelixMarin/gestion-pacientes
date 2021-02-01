package com.metaenlace.formacion.repository;

import org.springframework.data.repository.CrudRepository;

import com.metaenlace.formacion.model.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long>  {
	
}
