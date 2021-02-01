package com.metaenlace.formacion.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.metaenlace.formacion.dto.DiagnosticoDto;
import com.metaenlace.formacion.service.DiagnosticoService;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@RestController
@AllArgsConstructor
@RequestMapping("/diagnostico")
public class DiagnosticoController {
	
	private DiagnosticoService service;
		
	@JsonView(DiagnosticoDto.class)
	@GetMapping(value = "/all")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	
	@JsonView(DiagnosticoDto.class)
	@PostMapping(value = "/save")
	public ResponseEntity<?> save(@RequestBody @NonNull DiagnosticoDto diagnostico) {
		return ResponseEntity.ok().body(service.save(diagnostico));
	}
	
	@JsonView(DiagnosticoDto.class)
	@PostMapping(value = "/update")
	public ResponseEntity<?> modificarSaldo(@RequestBody @NonNull DiagnosticoDto diagnostico) throws IOException {
		return ResponseEntity.ok().body(service.update(diagnostico));
	}
	
	
	@JsonView(DiagnosticoDto.class)
	@PostMapping(value = "/find")
	public ResponseEntity<?> findById(@RequestBody @NonNull Long diagnostico) throws IOException {
		return ResponseEntity.ok().body(service.findById((diagnostico)));
	}
	
	@JsonView(DiagnosticoDto.class)
	@PostMapping(value = "/delete")
	public ResponseEntity<?> delete(@RequestBody @NonNull DiagnosticoDto diagnostico) throws IOException {
		return ResponseEntity.ok().body(service.delete((diagnostico)));
	}
}
