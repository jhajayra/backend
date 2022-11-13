package com.jhajayramori.app.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@Column(length = 600)
	private String descripcion;
	
	@OneToMany(mappedBy = "usuario")
	private Set<Educacion> educaciones = new HashSet<>();


	@OneToMany(mappedBy = "usuario")
	private Set<Experiencia> experiencias = new HashSet<>();
	
	@OneToMany(mappedBy = "usuario")
	private Set<Proyectos> proyectos  = new HashSet<>();
	
	@OneToMany(mappedBy = "usuario")
	private Set<Skills> skills  = new HashSet<>();
	
	@OneToMany(mappedBy = "usuario")
	private Set<SoftSkills> softs = new HashSet<>();

	public Usuario() {
		super();
	}

	public Usuario(Long idPer, @NotNull @NotBlank String nombreCompleto, String titulo, @NotBlank String descripcion) {
		super();
		this.idPer = idPer;
		this.nombreCompleto = nombreCompleto;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	
	

	public Usuario(Long idPer, @NotNull @NotBlank String nombreCompleto, String titulo, @NotBlank String descripcion,
			Set<Educacion> educaciones, Set<Experiencia> experiencias, Set<Proyectos> proyectos, Set<Skills> skills,
			Set<SoftSkills> softs) {
		super();
		this.idPer = idPer;
		this.nombreCompleto = nombreCompleto;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.educaciones = educaciones;
		this.experiencias = experiencias;
		this.proyectos = proyectos;
		this.skills = skills;
		this.softs = softs;
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

	public Set<Educacion> getEducaciones() {
		return educaciones;
	}

	public void setEducaciones(Set<Educacion> educaciones) {
		this.educaciones = educaciones;
	}

	public Set<Experiencia> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(Set<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

	public Set<Proyectos> getProyectos() {
		return proyectos;
	}

	public void setProyectos(Set<Proyectos> proyectos) {
		this.proyectos = proyectos;
	}

	public Set<Skills> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}

	public Set<SoftSkills> getSofts() {
		return softs;
	}

	public void setSofts(Set<SoftSkills> softs) {
		this.softs = softs;
	}
	
	
	
	
	
	
	


	 
	 
	 
}
