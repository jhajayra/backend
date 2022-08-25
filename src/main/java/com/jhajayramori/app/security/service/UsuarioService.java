package com.jhajayramori.app.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhajayramori.app.security.entity.User;
import com.jhajayramori.app.security.repository.iUsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	iUsuarioRepository iusuarioRepo;
	
	public Optional<User> getByNombreUsuario(String nombreUsuario){
		return iusuarioRepo.findByNombreUsuario(nombreUsuario);
	}

	public boolean existsByNombreUsuario(String nombreUsuario) {
		return iusuarioRepo.existsByNombreUsuario(nombreUsuario);
	}
	
	public boolean existsByEmail(String email) {
		return iusuarioRepo.existsByEmail(email);
				}
	
	public void save(User usuario) {
		iusuarioRepo.save(usuario);
	}
}
