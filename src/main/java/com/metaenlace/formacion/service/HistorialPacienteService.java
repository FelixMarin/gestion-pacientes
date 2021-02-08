package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.metaenlace.formacion.dto.HistorialPacienteDto;

import lombok.NonNull;

public interface HistorialPacienteService {

	abstract List<HistorialPacienteDto> findAll();
	abstract Optional<HistorialPacienteDto> findById(Long id) throws IOException;
	abstract Optional<HistorialPacienteDto> save(HistorialPacienteDto cita);
	abstract Optional<HistorialPacienteDto> update(@NonNull HistorialPacienteDto cita) throws IOException;
	abstract HistorialPacienteDto delete(HistorialPacienteDto cita);
	
}
