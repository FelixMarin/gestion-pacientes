package com.metaenlace.formacion.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaenlace.formacion.dto.ResultadoDto;
import com.metaenlace.formacion.service.MedicoService;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@RestController
@AllArgsConstructor
@RequestMapping("/medico")
public class MedicoController {
	
	private MedicoService service;
		
	@GetMapping(value = "/all", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ResultadoDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@PostMapping(value = "/save", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResultadoDto> save(@RequestBody @NonNull ResultadoDto medico) {
		return ResponseEntity.ok().body(service.save(medico).orElseThrow());
	}
	
	@PostMapping(value = "/update", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResultadoDto> modificarSaldo(@RequestBody @NonNull ResultadoDto medico) throws IOException {
		return ResponseEntity.ok().body(service.update(medico).orElseThrow());
	}
	
	@PostMapping(value = "/find", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResultadoDto> findById(@RequestBody @NonNull Long medico) throws IOException {
		return ResponseEntity.ok().body(service.findById((medico)).orElseThrow());
	}
	
	@PostMapping(value = "/delete", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Integer> delete(@RequestBody @NonNull ResultadoDto medico) throws IOException {
		return ResponseEntity.ok().body(service.delete((medico)));
	}
	
	@GetMapping(value = "/colegiado", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResultadoDto> colegiado(@NonNull String numColegiado) throws IOException {
		Optional<ResultadoDto> ores = service.findByNumColegiado(numColegiado);
		return ResponseEntity.ok().body(ores.orElseThrow());
	}
}
