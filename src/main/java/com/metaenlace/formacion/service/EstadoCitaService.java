package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.metaenlace.formacion.dto.EstadoCitaDto;

import lombok.NonNull;

public interface EstadoCitaService {

	abstract List<EstadoCitaDto> findAll();
	abstract Optional<EstadoCitaDto> findById(Long id) throws IOException;
	abstract Optional<EstadoCitaDto> save(EstadoCitaDto cita);
	abstract Optional<EstadoCitaDto> update(@NonNull EstadoCitaDto cita) throws IOException;
	abstract EstadoCitaDto delete(EstadoCitaDto cita);
	
}
