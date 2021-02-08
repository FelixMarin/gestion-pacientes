package com.metaenlace.formacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metaenlace.formacion.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

	@Query("from com.metaenlace.formacion.model.Usuario usu where usu.login = :usuario and usu.clave = :clave")
	Optional<Usuario> findByUsuarioAndClave(@Param("usuario") String usuario, @Param("clave") String clave);
}
