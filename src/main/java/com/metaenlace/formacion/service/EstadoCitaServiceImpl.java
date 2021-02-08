package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.metaenlace.formacion.dto.EstadoCitaDto;
import com.metaenlace.formacion.mapper.Mapper;
import com.metaenlace.formacion.model.EstadoCita;
import com.metaenlace.formacion.repository.EstadoCitaRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class EstadoCitaServiceImpl implements EstadoCitaService {
	
	private EstadoCitaRepository estadoCitaRepository;

	public List<EstadoCitaDto> findAll() {
		List<EstadoCitaDto> list = Lists.newArrayList();
		Iterable<EstadoCita> iterable = estadoCitaRepository.findAll();
		
		iterable.forEach(estadoCita -> {
			list.add(EstadoCitaDto.builder().id(estadoCita.getId())
					.nombre(estadoCita.getNombre())
					.fecCreacion(estadoCita.getFechaCreacion())
					.fecModificacion(estadoCita.getFechaModificacion()).build());
		});
		return list;
	}
	
	public Optional<EstadoCitaDto> findById(Long id) throws IOException {
		Optional<EstadoCita> estadoCita = estadoCitaRepository.findById(id);
		EstadoCitaDto citaDto = Mapper.getModelMapper().map(estadoCita.orElseThrow(() ->  
		new IOException()), EstadoCitaDto.class); 
		return Optional.of(citaDto);
	}
	
	public Optional<EstadoCitaDto> save(EstadoCitaDto estadoCita) {
		EstadoCita entidad = Mapper.getModelMapper().map(estadoCita, EstadoCita.class);
		return Optional.ofNullable(Mapper.getModelMapper()
				.map(estadoCitaRepository.save(entidad), EstadoCitaDto.class));
	}
	
	@Transactional
	public Optional<EstadoCitaDto> update(@NonNull EstadoCitaDto estadoCita) throws IOException {
		Optional<EstadoCita> res = estadoCitaRepository.findById(estadoCita.getId());
		EstadoCita entidad = res.orElseThrow(() -> new IOException()); 
		entidad.setId(estadoCita.getId());
		entidad.setNombre(estadoCita.getNombre());
		entidad.setFechaCreacion(estadoCita.getFecCreacion());
		entidad.setFechaModificacion(estadoCita.getFecModificacion());
		estadoCitaRepository.save(entidad);
		return Optional.ofNullable(Mapper.getModelMapper().map(entidad, EstadoCitaDto.class));
	}
	
	public EstadoCitaDto delete(EstadoCitaDto estadoCita) {
		estadoCitaRepository.delete(Mapper.getModelMapper().map(estadoCita, EstadoCita.class));
		return estadoCita;
	}
}
