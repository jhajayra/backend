package com.jhajayramori.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class SoftSkills implements Serializable {


	private static final long serialVersionUID = -3766897679415338964L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSoft;
	
	@NotBlank
	@NotNull
	@Column(length = 50, unique = true)
    private String nombreSoft;

	public SoftSkills(Long idSoft, @NotBlank @NotNull String nombreSoft) {
		this.idSoft = idSoft;
		this.nombreSoft = nombreSoft;
	}

	public SoftSkills() {
		
	}

	public Long getIdSoft() {
		return idSoft;
	}

	public void setIdSoft(Long idSoft) {
		this.idSoft = idSoft;
	}

	public String getNombreSoft() {
		return nombreSoft;
	}

	public void setNombreSoft(String nombreSoft) {
		this.nombreSoft = nombreSoft;
	}
	
	
	
	

}
