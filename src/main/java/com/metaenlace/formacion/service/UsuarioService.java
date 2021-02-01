package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.metaenlace.formacion.dto.UsuarioDto;

import lombok.NonNull;

public interface UsuarioService {

	abstract List<UsuarioDto> findAll();
	abstract Optional<UsuarioDto> findById(UsuarioDto usuario) throws IOException;
	abstract Optional<UsuarioDto> save(UsuarioDto cita);
	abstract Optional<UsuarioDto> update(@NonNull UsuarioDto cita) throws IOException;
	abstract UsuarioDto delete(UsuarioDto cita);
	abstract Optional<UsuarioDto> login(UsuarioDto usuario);
}
