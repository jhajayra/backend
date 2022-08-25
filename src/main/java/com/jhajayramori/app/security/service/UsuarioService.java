package com.jhajayramori.app.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhajayramori.app.security.entity.Usuario;
import com.jhajayramori.app.security.repository.iUsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	iUsuarioRepository iusuarioRepo;
	
	public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
		return iusuarioRepo.finByNombreUsuario(nombreUsuario);
	}

	public boolean existsByNombreUsuario(String nombreUsuario) {
		return iusuarioRepo.existByNombreUsuario(nombreUsuario);
	}
	
	public boolean existsByEmail(String email) {
		return iusuarioRepo.existByEmail(email);
				}
	
	public void save(Usuario usuario) {
		iusuarioRepo.save(usuario);
	}
}
