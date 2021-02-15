package com.metaenlace.formacion.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.metaenlace.formacion.dto.CitaDto;
import com.metaenlace.formacion.service.CitaService;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@RestController
@AllArgsConstructor
@RequestMapping("/cita")
public class CitaController {
	
	private CitaService service;
		
	@JsonView(CitaDto.class)
	@GetMapping(value = "/all")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	
	@JsonView(CitaDto.class)
	@PostMapping(value = "/save")
	public ResponseEntity<?> save(@RequestBody @NonNull CitaDto cita) {
		return ResponseEntity.ok().body(service.save(cita));
	}
	
	@JsonView(CitaDto.class)
	@PostMapping(value = "/update")
	public ResponseEntity<?> modificarSaldo(@RequestBody @NonNull CitaDto cita) throws IOException {
		return ResponseEntity.ok().body(service.update(cita));
	}
	
	
	@JsonView(CitaDto.class)
	@PostMapping(value = "/find")
	public ResponseEntity<?> findById(@RequestBody @NonNull Long cita) throws IOException {
		return ResponseEntity.ok().body(service.findById((cita)));
	}
	
	@JsonView(CitaDto.class)
	@PostMapping(value = "/delete")
	public ResponseEntity<?> delete(@RequestBody @NonNull CitaDto cita) throws IOException {
		return ResponseEntity.ok().body(service.delete((cita)));
	}
	
	@PostMapping(value = "/findbypaciente", consumes = "application/json")
	public ResponseEntity<?> findByPaciente(@RequestBody @NonNull CitaDto cita) throws IOException {
		return ResponseEntity.ok().body(service.findByIdPaciente((cita)));
	}
}
