package com.metaenlace.formacion.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaenlace.formacion.dto.PacienteDto;
import com.metaenlace.formacion.service.PacienteService;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@RestController
@AllArgsConstructor
@RequestMapping("/paciente")
public class PacienteController {
	
	private PacienteService service;
		
	@GetMapping(value = "/all")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<?> save(@RequestBody @NonNull PacienteDto paciente) {
		return ResponseEntity.ok().body(service.save(paciente));
	}
	
	@PostMapping(value = "/update")
	public ResponseEntity<?> modificarSaldo(@RequestBody @NonNull PacienteDto paciente) throws IOException {
		return ResponseEntity.ok().body(service.update(paciente));
	}
	
	@GetMapping(value = "/find")
	public ResponseEntity<?> findById(@NonNull String paciente) throws IOException {
		return ResponseEntity.ok().body(service.findById((Long.parseLong(paciente))));
	}
	
	@PostMapping(value = "/delete")
	public ResponseEntity<?> delete(@RequestBody @NonNull PacienteDto paciente) throws IOException {
		return ResponseEntity.ok().body(service.delete((paciente)));
	}
	
	
}
