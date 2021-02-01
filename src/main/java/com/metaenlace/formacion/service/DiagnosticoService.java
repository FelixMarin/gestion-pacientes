package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.metaenlace.formacion.dto.DiagnosticoDto;

import lombok.NonNull;

public interface DiagnosticoService {

	abstract List<DiagnosticoDto> findAll();
	abstract Optional<DiagnosticoDto> findById(Long id) throws IOException;
	abstract Optional<DiagnosticoDto> save(DiagnosticoDto diagnostico);
	abstract Optional<DiagnosticoDto> update(@NonNull DiagnosticoDto diagnostico) throws IOException;
	abstract DiagnosticoDto delete(DiagnosticoDto diagnostico);
}
