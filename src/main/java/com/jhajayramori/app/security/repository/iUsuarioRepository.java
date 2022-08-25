package com.jhajayramori.app.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhajayramori.app.security.entity.Usuario;

@Repository
public interface iUsuarioRepository extends JpaRepository <Usuario, Integer>{
	
	Optional <Usuario> finByNombreUsuario(String nombreUsuario);
	
	boolean existByNombreUsuario(String nombreUsuario);
	
	boolean existByEmail(String email);

	
	

}
