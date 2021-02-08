package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.metaenlace.formacion.dto.RolFuncionalDto;

import lombok.NonNull;

public interface RolFuncionalService {

	abstract List<RolFuncionalDto> findAll();
	abstract Optional<RolFuncionalDto> findById(Long id) throws IOException;
	abstract Optional<RolFuncionalDto> save(RolFuncionalDto rol);
	abstract Optional<RolFuncionalDto> update(@NonNull RolFuncionalDto rol) throws IOException;
	abstract RolFuncionalDto delete(RolFuncionalDto rol);
	
}
