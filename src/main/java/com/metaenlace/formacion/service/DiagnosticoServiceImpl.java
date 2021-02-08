package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.metaenlace.formacion.dto.DiagnosticoDto;
import com.metaenlace.formacion.mapper.Mapper;
import com.metaenlace.formacion.model.Diagnostico;
import com.metaenlace.formacion.repository.DiagnosticoRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class DiagnosticoServiceImpl implements DiagnosticoService {
	
	private DiagnosticoRepository diagnosticoRepository;

	public List<DiagnosticoDto> findAll() {
		List<DiagnosticoDto> list = Lists.newArrayList();
		Iterable<Diagnostico> iterable = diagnosticoRepository.findAll();
		
		iterable.forEach(diagnostico -> {
			list.add(DiagnosticoDto.builder()
					.id(diagnostico.getId())
					.fecCreacion(diagnostico.getFechaCreacion())
					.fecModificacion(diagnostico.getFechaModificacion())
					.paciente(diagnostico.getPaciente())
					.historial(diagnostico.getHistorial())
					.cita(diagnostico.getCita())
					.valoracionEspecialista(diagnostico.getValoracionEspecialista())
					.enfermedad(diagnostico.getEnfermedad()).build());
		});
		return list;
	}
	
	public Optional<DiagnosticoDto> findById(Long id) throws IOException {
		Optional<Diagnostico> diagnostico = diagnosticoRepository.findById(id);
		DiagnosticoDto diagnosticoDto = Mapper.getModelMapper().map(diagnostico.orElseThrow(() ->  
		new IOException()), DiagnosticoDto.class); 
		return Optional.of(diagnosticoDto);
	}
	
	public Optional<DiagnosticoDto> save(DiagnosticoDto diagnostico) {
		Diagnostico entidad = Mapper.getModelMapper().map(diagnostico, Diagnostico.class);
		return Optional.ofNullable(Mapper.getModelMapper().map(diagnosticoRepository.save(entidad), DiagnosticoDto.class));
	}
	
	@Transactional
	public Optional<DiagnosticoDto> update(@NonNull DiagnosticoDto diagnostico) throws IOException {
		Optional<Diagnostico> res = diagnosticoRepository.findById(diagnostico.getId());
		Diagnostico entidad = res.orElseThrow(() -> new IOException()); 
		entidad.setCita(diagnostico.getCita());
		entidad.setEnfermedad(diagnostico.getEnfermedad());
		entidad.setFechaCreacion(diagnostico.getFecCreacion());
		entidad.setFechaModificacion(diagnostico.getFecModificacion());
		entidad.setHistorial(diagnostico.getHistorial());
		entidad.setPaciente(diagnostico.getPaciente());
		entidad.setValoracionEspecialista(diagnostico.getValoracionEspecialista());
		diagnosticoRepository.save(entidad);
		return Optional.ofNullable(Mapper.getModelMapper().map(entidad, DiagnosticoDto.class));
	}
	
	public DiagnosticoDto delete(DiagnosticoDto diagnostico) {
		diagnosticoRepository.delete(Mapper.getModelMapper().map(diagnostico, Diagnostico.class));
		return diagnostico;
	}
}
