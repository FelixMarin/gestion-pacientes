package com.metaenlace.formacion.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.metaenlace.formacion.model.Medico;

public interface MedicoRepository extends CrudRepository<Medico, Long>  {

	Optional<Medico> findByNumColegiado(String numColegiado);
	
}
