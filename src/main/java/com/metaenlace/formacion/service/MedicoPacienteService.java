package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.metaenlace.formacion.dto.MedicoPacienteDto;

import lombok.NonNull;

public interface MedicoPacienteService {

	abstract List<MedicoPacienteDto> findAll();
	abstract Optional<MedicoPacienteDto> findById(Long id) throws IOException;
	abstract Optional<MedicoPacienteDto> save(MedicoPacienteDto medicoPaciente);
	abstract Optional<MedicoPacienteDto> update(@NonNull MedicoPacienteDto medicoPaciente) throws IOException;
	abstract MedicoPacienteDto delete(MedicoPacienteDto medicoPaciente);
	
}
