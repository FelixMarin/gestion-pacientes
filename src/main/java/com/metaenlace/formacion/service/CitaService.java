package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.metaenlace.formacion.dto.CitaDto;

import lombok.NonNull;

public interface CitaService {

	abstract List<CitaDto> findAll();
	abstract Optional<CitaDto> findById(Long id) throws IOException;
	abstract Optional<CitaDto> save(CitaDto cita);
	abstract Optional<CitaDto> update(@NonNull CitaDto cita) throws IOException;
	abstract CitaDto delete(CitaDto cita);
	
}
