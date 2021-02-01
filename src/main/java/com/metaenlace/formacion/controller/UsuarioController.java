package com.metaenlace.formacion.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metaenlace.formacion.dto.UsuarioDto;
import com.metaenlace.formacion.service.UsuarioService;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {
	
	private UsuarioService service;

	@JsonView(UsuarioDto.class)
	@GetMapping(value = "/all")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@JsonView(UsuarioDto.class)
	@PostMapping(value = "/save")
	public ResponseEntity<?> save(@RequestBody @NonNull UsuarioDto usuarios) {
		Optional<UsuarioDto> usuario =service.save(usuarios);
		return ResponseEntity.ok().body(usuario.orElseThrow());
	}
	
	@JsonView(UsuarioDto.class)
	@PostMapping(value = "/update")
	public ResponseEntity<?> modificarSaldo(@RequestBody @NonNull UsuarioDto usuarios) throws IOException {
		Optional<UsuarioDto> usuario = service.update(usuarios);
		return ResponseEntity.ok().body(usuario.orElseThrow());
	}
	
	@PostMapping(value = "/find")
	public ResponseEntity<?> findById(@RequestBody @NonNull String json) throws IOException {
		Optional<UsuarioDto> usuario = service.findById((new ObjectMapper().readValue(json, UsuarioDto.class)));
		return ResponseEntity.ok().body(usuario.orElseThrow());
	}
	
	@JsonView(UsuarioDto.class)
	@PostMapping(value = "/delete")
	public ResponseEntity<?> delete(@RequestBody @NonNull UsuarioDto usuarios) throws IOException {
		return ResponseEntity.ok().body(service.delete((usuarios)));
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody @NonNull UsuarioDto dto) throws IOException {
		Optional<UsuarioDto> usuario = service.login(dto);
		return ResponseEntity.ok().body(usuario.orElseThrow());
	}
}
