package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.metaenlace.formacion.dto.FuncionalDto;

import lombok.NonNull;

public interface FuncionalService {

	abstract List<FuncionalDto> findAll();
	abstract Optional<FuncionalDto> findById(Long id) throws IOException;
	abstract Optional<FuncionalDto> save(FuncionalDto funcional);
	abstract Optional<FuncionalDto> update(@NonNull FuncionalDto funcional) throws IOException;
	abstract FuncionalDto delete(FuncionalDto funcional);
	
}
