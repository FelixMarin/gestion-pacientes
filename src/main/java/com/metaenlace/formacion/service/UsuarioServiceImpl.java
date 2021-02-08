package com.metaenlace.formacion.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.metaenlace.formacion.dto.UsuarioDto;
import com.metaenlace.formacion.mapper.Mapper;
import com.metaenlace.formacion.model.Usuario;
import com.metaenlace.formacion.repository.UsuarioRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository usuarioRepository;

	public List<UsuarioDto> findAll() {
		List<UsuarioDto> list = Lists.newArrayList();
		Iterable<Usuario> iterable = usuarioRepository.findAll();
		
		iterable.forEach(usuario -> {
			list.add(UsuarioDto.builder()
					.id(usuario.getId())
					.nombre(usuario.getNombre())
					.apellidos(usuario.getApellidos())
					.namelogin(usuario.getLogin())
					.tipoUsuario(usuario.getTipoUsuario())
					.fecCreacion(usuario.getFechaCreacion())
					.fecModificacion(usuario.getFechaModificacion())
					.clave(usuario.getClave()).build());
		});
		return list;
	}
	
	public Optional<UsuarioDto> findById(UsuarioDto usuario) throws IOException {
		Optional<Usuario> paciente = usuarioRepository.findById(usuario.getId());
		UsuarioDto pacienteDto = Mapper.getModelMapper().map(paciente.orElseThrow(() ->  
		new IOException()), UsuarioDto.class); 
		return Optional.of(pacienteDto);
	}
	
	public Optional<UsuarioDto> save(UsuarioDto paciente) {
		Usuario entidad = Mapper.getModelMapper().map(paciente, Usuario.class);
		return Optional.ofNullable(Mapper.getModelMapper().map(usuarioRepository.save(entidad), UsuarioDto.class));
	}
	
	@Transactional
	public Optional<UsuarioDto> update(@NonNull UsuarioDto usuario) throws IOException {
		Optional<Usuario> res = usuarioRepository.findById(usuario.getId());
		Usuario entidad = res.orElseThrow(() -> new IOException()); 
		entidad.setId(usuario.getId());
		entidad.setNombre(usuario.getNombre());
		entidad.setApellidos(usuario.getApellidos());
		entidad.setClave(usuario.getClave());
		usuarioRepository.save(entidad);
		return Optional.ofNullable(Mapper.getModelMapper().map(entidad, UsuarioDto.class));
	}
	
	public UsuarioDto delete(UsuarioDto paciente) {
		usuarioRepository.delete(Mapper.getModelMapper().map(paciente, Usuario.class));
		return paciente;
	}
	
	public Optional<UsuarioDto> login(UsuarioDto usuario) {
		Optional<Usuario> oEntity = usuarioRepository.findByUsuarioAndClave(usuario.getNamelogin(), usuario.getClave());
		Usuario entity = oEntity.orElseThrow();
		UsuarioDto dto = UsuarioDto.builder()
				.id(entity.getId())
				.tipoUsuario(entity.getTipoUsuario())
				.nombre(entity.getNombre())
				.apellidos(entity.getApellidos())
				.namelogin(entity.getLogin())
				.clave(entity.getClave())
				.fecCreacion(entity.getFechaCreacion())
				.fecModificacion(entity.getFechaModificacion())
				.usuario(entity.getLogin()).build();
		return Optional.ofNullable(dto);
	}
}
