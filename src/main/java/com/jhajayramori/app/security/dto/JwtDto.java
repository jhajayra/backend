package com.jhajayramori.app.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDto {

	private String token;

	private String bearer = "Bearer";

	private String nombreUsuario;

	private Collection<? extends GrantedAuthority> authtorities;

	// CONSTRUCTORES
	public JwtDto() {

	}

	public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authtorities) {
		this.token = token;
		this.nombreUsuario = nombreUsuario;
		this.authtorities = authtorities;
	}
	
	//GETTERS Y SETTERS

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBearer() {
		return bearer;
	}

	public void setBearer(String bearer) {
		this.bearer = bearer;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Collection<? extends GrantedAuthority> getAuthtorities() {
		return authtorities;
	}

	public void setAuthtorities(Collection<? extends GrantedAuthority> authtorities) {
		this.authtorities = authtorities;
	}

}
