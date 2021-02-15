package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.metaenlace.formacion.dto.CitaDto;
import com.metaenlace.formacion.mapper.Mapper;
import com.metaenlace.formacion.model.Cita;
import com.metaenlace.formacion.repository.CitaRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class CitaServiceImpl implements CitaService {
	
	private CitaRepository citaRepository;

	public List<CitaDto> findAll() {
		List<CitaDto> list = Lists.newArrayList();
		Iterable<Cita> iterable = citaRepository.findAll();
		
		iterable.forEach(cita -> {
			list.add(CitaDto.builder()
					.id(cita.getId())
					.paciente(cita.getPaciente())
					.medico(cita.getMedico())
					.historial(cita.getHistorial())
					.estado(cita.getEstado())
					.paciente(cita.getPaciente())
					.fecHoraCita(cita.getFechaHoraCita())
					.fecCreacion(cita.getFechaCreacion())
					.fecModificacion(cita.getFechaModificacion())
					.motivoCita(cita.getMotivoCita()).build());
		});
		return list;
	}
	
	public Optional<CitaDto> findById(Long id) throws IOException {
		Optional<Cita> cita = citaRepository.findById(id);
		CitaDto citaDto = Mapper.getModelMapper().map(cita.orElseThrow(() ->  
		new IOException()), CitaDto.class); 
		return Optional.of(citaDto);
	}
	
	public Optional<CitaDto> save(CitaDto cita) {
		Cita entidad = Mapper.getModelMapper().map(cita, Cita.class);
		return Optional.ofNullable(Mapper.getModelMapper()
				.map(citaRepository.save(entidad), CitaDto.class));
	}
	
	@Transactional
	public Optional<CitaDto> update(@NonNull CitaDto cita) throws IOException {
		Optional<Cita> res = citaRepository.findById(cita.getId());
		Cita entidad = res.orElseThrow(() -> new IOException()); 
		entidad.setMedico(cita.getMedico());
		entidad.setEstado(cita.getEstado());
		entidad.setFechaCreacion(cita.getFecCreacion());
		entidad.setFechaModificacion(cita.getFecModificacion());
		entidad.setMotivoCita(cita.getMotivoCita());
		entidad.setPaciente(cita.getPaciente());
		entidad.setHistorial(cita.getHistorial());
		citaRepository.save(entidad);
		return Optional.ofNullable(Mapper.getModelMapper().map(entidad, CitaDto.class));
	}
	
	public CitaDto delete(CitaDto cita) {
		citaRepository.delete(Mapper.getModelMapper().map(cita, Cita.class));
		return cita;
	}
	
	public List<Optional<CitaDto>>  findByIdPaciente(@NonNull CitaDto cita) throws IOException {
		List<Optional<Cita>> citasList =  citaRepository.findByIdPaciente(cita.getId());
		List<Optional<CitaDto>> citasDtoList = Lists.newArrayList();
		citasList.forEach(OpCita -> {
			OpCita.ifPresent(elem -> {
				CitaDto citaDto = CitaDto.builder()
				.estado(elem.getEstado())
				.fecCreacion(elem.getFechaCreacion())
				.fecHoraCita(elem.getFechaHoraCita())
				.fecModificacion(elem.getFechaModificacion())
				.historial(elem.getHistorial())
				.id(elem.getId())
				.medico(elem.getMedico())
				.motivoCita(elem.getMotivoCita())
				.paciente(elem.getPaciente()).build();	
				
				citasDtoList.add(Optional.of(citaDto));
			});
		});
		return citasDtoList;
	}
	
}
