package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.metaenlace.formacion.dto.MedicacionDto;
import com.metaenlace.formacion.mapper.Mapper;
import com.metaenlace.formacion.model.Medicacion;
import com.metaenlace.formacion.repository.MedicacionRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class MedicacionServiceImpl implements MedicacionService {
	
	private MedicacionRepository medicacionRepository;

	public List<MedicacionDto> findAll() {
		List<MedicacionDto> list = Lists.newArrayList();
		Iterable<Medicacion> iterable = medicacionRepository.findAll();
		
		iterable.forEach(medicacion -> {
			list.add(MedicacionDto.builder()
					.id(medicacion.getId()).cantidad(medicacion.getCantidad())
					.diagnostico(medicacion.getDiagnostico())
					.fecCreacion(medicacion.getFechaCreacion())
					.fecFin(medicacion.getFecFin())
					.fecIni(medicacion.getFecIni())
					.fecModificacion(medicacion.getFechaModificacion())
					.frecuencia(medicacion.getFrecuencia())
					.nombre(medicacion.getNombre())
					.alergico(medicacion.getAlergico())
					.paciente(medicacion.getPaciente()).build());
		});
		return list;
	}
	
	public Optional<MedicacionDto> findById(Long id) throws IOException {
		Optional<Medicacion> medicacion = medicacionRepository.findById(id);
		MedicacionDto medicacionDto = Mapper.getModelMapper().map(medicacion.orElseThrow(() ->  
		new IOException()), MedicacionDto.class); 
		return Optional.of(medicacionDto);
	}
	
	public Optional<MedicacionDto> save(MedicacionDto medicacion) {
		Medicacion entidad = Mapper.getModelMapper().map(medicacion, Medicacion.class);
		return Optional.ofNullable(Mapper.getModelMapper()
				.map(medicacionRepository.save(entidad), MedicacionDto.class));
	}
	
	@Transactional
	public Optional<MedicacionDto> update(@NonNull MedicacionDto medicacion) throws IOException {
		Optional<Medicacion> res = medicacionRepository.findById(medicacion.getId());
		Medicacion entidad = res.orElseThrow(() -> new IOException()); 
		entidad.setAlergico(medicacion.getAlergico());
		entidad.setCantidad(medicacion.getCantidad());
		entidad.setDiagnostico(medicacion.getDiagnostico());
		entidad.setFecFin(medicacion.getFecFin());
		entidad.setFechaCreacion(medicacion.getFecCreacion());
		entidad.setFechaModificacion(medicacion.getFecModificacion());
		entidad.setFecIni(medicacion.getFecIni());
		entidad.setFrecuencia(medicacion.getFrecuencia());
		entidad.setId(medicacion.getId());
		entidad.setNombre(medicacion.getNombre());
		entidad.setPaciente(medicacion.getPaciente());
		medicacionRepository.save(entidad);
		return Optional.ofNullable(Mapper.getModelMapper().map(entidad, MedicacionDto.class));
	}
	
	public MedicacionDto delete(MedicacionDto medicacion) {
		medicacionRepository.delete(Mapper.getModelMapper().map(medicacion, Medicacion.class));
		return medicacion;
	}
}
