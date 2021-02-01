package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.metaenlace.formacion.dto.ResultadoDto;

import lombok.NonNull;

public interface MedicoService {

	abstract List<ResultadoDto> findAll();
	abstract Optional<ResultadoDto> findById(Long id) throws IOException;
	abstract Optional<ResultadoDto> save(ResultadoDto medico);
	abstract Optional<ResultadoDto> update(@NonNull ResultadoDto medico) throws IOException;
	abstract int delete(ResultadoDto medico);
	abstract Optional<ResultadoDto> findByNumColegiado(String numColegiado) throws IOException;
}
