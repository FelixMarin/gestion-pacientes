package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.metaenlace.formacion.dto.FuncionalDto;
import com.metaenlace.formacion.mapper.Mapper;
import com.metaenlace.formacion.model.Funcional;
import com.metaenlace.formacion.repository.FuncionalRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class FuncionalServiceImpl implements FuncionalService {
	
	private FuncionalRepository funcionalRepository;

	public List<FuncionalDto> findAll() {
		List<FuncionalDto> list = Lists.newArrayList();
		Iterable<Funcional> iterable = funcionalRepository.findAll();
		
		iterable.forEach(funcional -> {
			list.add(FuncionalDto.builder()
					.id(funcional.getId())
					.usuario(funcional.getUsuario())
					.rol(funcional.getRolFuncional())
					.usuario(funcional.getUsuario())
					.clave(funcional.getClave())
					.fecCreacion(funcional.getFechaCreacion())
					.fecModificacion(funcional.getFechaModificacion())
					.build());
		});
		return list;
	}
	
	public Optional<FuncionalDto> findById(Long id) throws IOException {
		Optional<Funcional> funcional = funcionalRepository.findById(id);
		FuncionalDto citaDto = Mapper.getModelMapper().map(funcional.orElseThrow(() ->  
		new IOException()), FuncionalDto.class); 
		return Optional.of(citaDto);
	}
	
	public Optional<FuncionalDto> save(FuncionalDto funcional) {
		Funcional entidad = Mapper.getModelMapper().map(funcional, Funcional.class);
		return Optional.ofNullable(Mapper.getModelMapper()
				.map(funcionalRepository.save(entidad), FuncionalDto.class));
	}
	
	@Transactional
	public Optional<FuncionalDto> update(@NonNull FuncionalDto funcional) throws IOException {
		Optional<Funcional> res = funcionalRepository.findById(funcional.getId());
		Funcional entidad = res.orElseThrow(() -> new IOException()); 
		entidad.setId(funcional.getId());
		entidad.setRolFuncional(funcional.getRol());
		entidad.setUsuario(funcional.getUsuario());
		entidad.setClave(funcional.getClave());
		entidad.setFechaCreacion(funcional.getFecCreacion());
		entidad.setFechaModificacion(funcional.getFecModificacion());
		funcionalRepository.save(entidad);
		return Optional.ofNullable(Mapper.getModelMapper().map(entidad, FuncionalDto.class));
	}
	
	public FuncionalDto delete(FuncionalDto funcional) {
		funcionalRepository.delete(Mapper.getModelMapper().map(funcional, Funcional.class));
		return funcional;
	}
}
