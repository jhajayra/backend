package com.jhajayramori.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity

public class Usuario implements Serializable {

	private static final long serialVersionUID = 356311062995687933L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idPer;
	 
	@NotNull
	@NotBlank
	@Column(length = 50)
	 private String nombreCompleto;
	 
	@Column(length = 50)
	private String titulo;
	
	@NotBlank
	private String descripcion;

	
	
	public Usuario() {
	}

	
	
	public Usuario(Long idPer, String nombreCompleto, String titulo, String descripcion) {
		super();
		this.idPer = idPer;
		this.nombreCompleto = nombreCompleto;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}



	public Long getIdPer() {
		return idPer;
	}

	public void setIdPer(Long idPer) {
		this.idPer = idPer;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	 
	 
	 
}
