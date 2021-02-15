package com.metaenlace.formacion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.metaenlace.formacion.model.Cita;

public interface CitaRepository extends CrudRepository<Cita, Long> {

	@Query("from com.metaenlace.formacion.model.Cita ci where ci.paciente.id = :id")
	abstract List<Optional<Cita>> findByIdPaciente(@Param("id") Long idPaciente);
}
