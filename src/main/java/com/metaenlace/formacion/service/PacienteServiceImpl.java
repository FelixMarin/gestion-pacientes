package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.metaenlace.formacion.dto.PacienteDto;
import com.metaenlace.formacion.dto.ResultadoDto;
import com.metaenlace.formacion.mapper.Mapper;
import com.metaenlace.formacion.model.Paciente;
import com.metaenlace.formacion.repository.PacienteRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class PacienteServiceImpl implements PacienteService {
	
	private PacienteRepository pacienteRepository;

	public List<ResultadoDto> findAll() {
		List<ResultadoDto> listaResultado = Lists.newArrayList();
		
		Iterable<Paciente> pacientes = pacienteRepository.findAll();
		
		pacientes.forEach(paciente -> {
			ResultadoDto res = ResultadoDto.builder().id(paciente.getUsuario().getId())
					.nnss(paciente.getNnss()).nombre(paciente.getUsuario().getNombre())
					.apellidos(paciente.getUsuario().getApellidos())
					.clave(paciente.getUsuario().getClave())
					.medicoAsignado(paciente.getMedico())
					.numTarjeta(paciente.getNumTarjeta())
					.usuario(paciente.getUsuario().getLogin())
					.telefono(paciente.getTelefono()).build();
			listaResultado.add(res);
		});
		
		
		return listaResultado;
	}
	
	public Optional<PacienteDto> findById(Long id) throws IOException {
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		PacienteDto pacienteDto = Mapper.getModelMapper().map(paciente.orElseThrow(() ->  
		new IOException()), PacienteDto.class); 
		return Optional.of(pacienteDto);
	}
	
	public Optional<PacienteDto> save(PacienteDto paciente) {
		Paciente entidad = Mapper.getModelMapper().map(paciente, Paciente.class);
		return Optional.ofNullable(Mapper.getModelMapper().map(pacienteRepository.save(entidad), PacienteDto.class));
	}
	
	@Transactional
	public Optional<PacienteDto> update(@NonNull PacienteDto paciente) throws IOException {
		Optional<Paciente> res = pacienteRepository.findById(paciente.getId());
		Paciente entidad = res.orElseThrow(() -> new IOException()); 
		entidad.setNnss(paciente.getNnss());
		entidad.setNumTarjeta(paciente.getNumTarjeta());
		entidad.setMedico(paciente.getMedico());
		entidad.setTelefono(paciente.getTelefono());
		pacienteRepository.save(entidad);
		return Optional.ofNullable(Mapper.getModelMapper().map(entidad, PacienteDto.class));
	}
	
	public PacienteDto delete(PacienteDto paciente) {
		pacienteRepository.delete(Mapper.getModelMapper().map(paciente, Paciente.class));
		return paciente;
	}
}
