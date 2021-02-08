package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.metaenlace.formacion.dto.HistorialPacienteDto;
import com.metaenlace.formacion.mapper.Mapper;
import com.metaenlace.formacion.model.HistorialPaciente;
import com.metaenlace.formacion.repository.HistorialPacienteRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class HistorialPacienteServiceImpl implements HistorialPacienteService {
	
	private HistorialPacienteRepository historialRepository;

	public List<HistorialPacienteDto> findAll() {
		List<HistorialPacienteDto> list = Lists.newArrayList();
		Iterable<HistorialPaciente> iterable = historialRepository.findAll();
		
		iterable.forEach(historial -> {
			list.add(HistorialPacienteDto.builder()
					.id(historial.getId())
					.paciente(historial.getPaciente())
					.historial(historial.getHistorial())
					.fecCreacion(historial.getFechaCreacion())
					.fecModificacion(historial.getFechaModificacion())
					.build());
		});
		return list;
	}
	
	public Optional<HistorialPacienteDto> findById(Long id) throws IOException {
		Optional<HistorialPaciente> historial = historialRepository.findById(id);
		HistorialPacienteDto historialDto = Mapper.getModelMapper().map(historial.orElseThrow(() ->  
		new IOException()), HistorialPacienteDto.class); 
		return Optional.of(historialDto);
	}
	
	public Optional<HistorialPacienteDto> save(HistorialPacienteDto historial) {
		HistorialPaciente entidad = Mapper.getModelMapper().map(historial, HistorialPaciente.class);
		return Optional.ofNullable(Mapper.getModelMapper()
				.map(historialRepository.save(entidad), HistorialPacienteDto.class));
	}
	
	@Transactional
	public Optional<HistorialPacienteDto> update(@NonNull HistorialPacienteDto historial) throws IOException {
		Optional<HistorialPaciente> res = historialRepository.findById(historial.getId());
		HistorialPaciente entidad = res.orElseThrow(() -> new IOException()); 
		entidad.setId(historial.getId());
		entidad.setHistorial(historial.getHistorial());
		entidad.setPaciente(historial.getPaciente());
		entidad.setFechaCreacion(historial.getFecCreacion());
		entidad.setFechaModificacion(historial.getFecModificacion());
		historialRepository.save(entidad);
		return Optional.ofNullable(Mapper.getModelMapper().map(entidad, HistorialPacienteDto.class));
	}
	
	public HistorialPacienteDto delete(HistorialPacienteDto historial) {
		historialRepository.delete(Mapper.getModelMapper().map(historial, HistorialPaciente.class));
		return historial;
	}
}
