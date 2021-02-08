package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.metaenlace.formacion.dto.MedicoPacienteDto;
import com.metaenlace.formacion.mapper.Mapper;
import com.metaenlace.formacion.model.MedicoPaciente;
import com.metaenlace.formacion.repository.MedicoPacienteRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class MedicoPacienteServiceImpl implements MedicoPacienteService {
	
	private MedicoPacienteRepository medicoPacienteRepository;

	public List<MedicoPacienteDto> findAll() {
		List<MedicoPacienteDto> list = Lists.newArrayList();
		Iterable<MedicoPaciente> iterable = medicoPacienteRepository.findAll();
		
		iterable.forEach(medicoPaciente -> {
			list.add(MedicoPacienteDto.builder()
					.paciente(medicoPaciente.getPaciente())
					.medico(medicoPaciente.getMedico())
					.fecCreacion(medicoPaciente.getFechaCreacion())
					.fecModificacion(medicoPaciente.getFechaModificacion()).build());
		});
		return list;
	}
	
	public Optional<MedicoPacienteDto> findById(Long id) throws IOException {
		Optional<MedicoPaciente> medicoPaciente = medicoPacienteRepository.findById(id);
		MedicoPacienteDto medicoPacienteDto = Mapper.getModelMapper().map(medicoPaciente.orElseThrow(() ->  
		new IOException()), MedicoPacienteDto.class); 
		return Optional.of(medicoPacienteDto);
	}
	
	public Optional<MedicoPacienteDto> save(MedicoPacienteDto medicoPaciente) {
		MedicoPaciente entidad = Mapper.getModelMapper().map(medicoPaciente, MedicoPaciente.class);
		return Optional.ofNullable(Mapper.getModelMapper()
				.map(medicoPacienteRepository.save(entidad), MedicoPacienteDto.class));
	}
	
	@Transactional
	public Optional<MedicoPacienteDto> update(@NonNull MedicoPacienteDto medicoPaciente) throws IOException {
		Optional<MedicoPaciente> res = medicoPacienteRepository.findById(medicoPaciente.getPaciente().getId());
		MedicoPaciente entidad = res.orElseThrow(() -> new IOException()); 
		entidad.setMedico(medicoPaciente.getMedico());
		entidad.setFechaCreacion(medicoPaciente.getFecCreacion());
		entidad.setFechaModificacion(medicoPaciente.getFecModificacion());
		entidad.setPaciente(medicoPaciente.getPaciente());
		medicoPacienteRepository.save(entidad);
		return Optional.ofNullable(Mapper.getModelMapper().map(entidad, MedicoPacienteDto.class));
	}
	
	public MedicoPacienteDto delete(MedicoPacienteDto medicoPaciente) {
		medicoPacienteRepository.delete(Mapper.getModelMapper().map(medicoPaciente, MedicoPaciente.class));
		return medicoPaciente;
	}
}
