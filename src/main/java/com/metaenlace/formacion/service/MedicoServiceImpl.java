package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.metaenlace.formacion.dto.ResultadoDto;
import com.metaenlace.formacion.mapper.Mapper;
import com.metaenlace.formacion.model.Medico;
import com.metaenlace.formacion.repository.MedicoRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class MedicoServiceImpl implements MedicoService {
	
	private MedicoRepository medicoRepository;

	public List<ResultadoDto> findAll() {
		List<ResultadoDto> list = Lists.newArrayList();
		Iterable<Medico> iterable = medicoRepository.findAll();
		
		iterable.forEach(medico -> {
			ResultadoDto res = ResultadoDto.builder().id(medico.getId())
					.nombre(medico.getNombre()).apellidos(medico.getApellidos()).clave(medico.getClave())
					.numColegiado(medico.getNumColegiado()).usuario(medico.getUsuario()).build();
			list.add(res);
		});
		return list;
	}
	
	public Optional<ResultadoDto> findById(Long id) throws IOException {
		Optional<Medico> medico = medicoRepository.findById(id);
		ResultadoDto resultadoDto = Mapper.getModelMapper().map(medico.orElseThrow(() ->  
		new IOException()), ResultadoDto.class); 
		return Optional.of(resultadoDto);
	}
	
	public Optional<ResultadoDto> save(ResultadoDto medico) {
		Medico entidad = Mapper.getModelMapper().map(medico, Medico.class);
		return Optional.ofNullable(Mapper.getModelMapper().map(medicoRepository.save(entidad), ResultadoDto.class));
	}
	
	@Transactional
	public Optional<ResultadoDto> update(@NonNull ResultadoDto medico) throws IOException {
		Optional<Medico> res = medicoRepository.findById(medico.getId());
		Medico entidad = res.orElseThrow(() -> new IOException()); 
		entidad.setNumColegiado(medico.getNumColegiado());
		medicoRepository.save(entidad);
		return Optional.ofNullable(Mapper.getModelMapper().map(entidad, ResultadoDto.class));
	}
	
	public int delete(ResultadoDto medico) {
		medicoRepository.delete(Mapper.getModelMapper().map(medico, Medico.class));
		return 1;
	}
	
	public Optional<ResultadoDto> findByNumColegiado(String numColegiado) throws IOException  {
		Optional<Medico> res = medicoRepository.findByNumColegiado(numColegiado);
		ResultadoDto resultadoDto = Mapper.getModelMapper().map(res.orElseThrow(() ->  
		new IOException()), ResultadoDto.class); 
		return Optional.ofNullable(resultadoDto);
	}
}
