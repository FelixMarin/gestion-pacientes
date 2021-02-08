package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.metaenlace.formacion.dto.MedicacionDto;

import lombok.NonNull;

public interface MedicacionService {

	abstract List<MedicacionDto> findAll();
	abstract Optional<MedicacionDto> findById(Long id) throws IOException;
	abstract Optional<MedicacionDto> save(MedicacionDto medicacion);
	abstract Optional<MedicacionDto> update(@NonNull MedicacionDto medicacion) throws IOException;
	abstract MedicacionDto delete(MedicacionDto medicacion);
	
}
