package com.jhajayramori.app.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jhajayramori.app.security.entity.Usuario;
import com.jhajayramori.app.security.entity.UsuarioPrincipal;

@Service
public class UserDetailsImpl implements UserDetailsService{
	
	
	@Autowired
	UsuarioService usuarioServ;

	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioServ.getByNombreUsuario(nombreUsuario).get();
		return UsuarioPrincipal.build(usuario);
	}
	
	
	
	

}
