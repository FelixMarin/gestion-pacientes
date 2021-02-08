package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.metaenlace.formacion.dto.RolFuncionalDto;
import com.metaenlace.formacion.mapper.Mapper;
import com.metaenlace.formacion.model.RolFuncional;
import com.metaenlace.formacion.repository.RolFuncionalRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class RolFuncionalServiceImpl implements RolFuncionalService {
	
	private RolFuncionalRepository rolRepository;

	public List<RolFuncionalDto> findAll() {
		List<RolFuncionalDto> list = Lists.newArrayList();
		Iterable<RolFuncional> iterable = rolRepository.findAll();
		
		iterable.forEach(rol -> {
			list.add(RolFuncionalDto.builder()
					.id(rol.getId())
					.descripcion(rol.getDescripcion())
					.fecCreacion(rol.getFechaCreacion())
					.fecModificacion(rol.getFechaModificacion()).build());
		});
		return list;
	}
	
	public Optional<RolFuncionalDto> findById(Long id) throws IOException {
		Optional<RolFuncional> rol = rolRepository.findById(id);
		RolFuncionalDto rolDto = Mapper.getModelMapper().map(rol.orElseThrow(() ->  
		new IOException()), RolFuncionalDto.class); 
		return Optional.of(rolDto);
	}
	
	public Optional<RolFuncionalDto> save(RolFuncionalDto rol) {
		RolFuncional entidad = Mapper.getModelMapper().map(rol, RolFuncional.class);
		return Optional.ofNullable(Mapper.getModelMapper()
				.map(rolRepository.save(entidad), RolFuncionalDto.class));
	}
	
	@Transactional
	public Optional<RolFuncionalDto> update(@NonNull RolFuncionalDto rol) throws IOException {
		Optional<RolFuncional> res = rolRepository.findById(rol.getId());
		RolFuncional entidad = res.orElseThrow(() -> new IOException()); 
		entidad.setDescripcion(rol.getDescripcion());
		entidad.setFechaCreacion(rol.getFecCreacion());		
		entidad.setFechaModificacion(rol.getFecModificacion());
		rolRepository.save(entidad);
		return Optional.ofNullable(Mapper.getModelMapper().map(entidad, RolFuncionalDto.class));
	}
	
	public RolFuncionalDto delete(RolFuncionalDto rol) {
		rolRepository.delete(Mapper.getModelMapper().map(rol, RolFuncional.class));
		return rol;
	}
}
