package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.metaenlace.formacion.dto.PacienteDto;
import com.metaenlace.formacion.dto.ResultadoDto;

import lombok.NonNull;

public interface PacienteService {

	abstract List<ResultadoDto> findAll();
	abstract Optional<PacienteDto> findById(Long id) throws IOException;
	abstract Optional<PacienteDto> save(PacienteDto paciente);
	abstract Optional<PacienteDto> update(@NonNull PacienteDto paciente) throws IOException;
	abstract PacienteDto delete(PacienteDto paciente);
}
