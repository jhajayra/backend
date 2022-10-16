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
public class Experiencia implements Serializable {

	private static final long serialVersionUID = -2808601829196012309L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExp;

	@NotBlank
	@NotNull
	@Column(length = 50, unique = true)
	private String cargoExp;

	@NotBlank
	@Column(length = 50)
	private String lugarExp;

	@NotNull
	@NotBlank
	@Column(length = 4)
	private int anioInicio;

	@NotBlank
	@Column(length = 10)
	private String mesInicio;
	
	@NotNull
	@NotBlank
	@Column(length = 4)
	private int anioFin;
	
	@NotBlank
	@Column(length = 10)
	private String mesFin;

    public Experiencia(){
    }

	

	


	public Experiencia(Long idExp, @NotBlank @NotNull String cargoExp, @NotBlank String lugarExp,
			@NotNull int anioInicio, @NotBlank String mesInicio, @NotNull int anioFin, @NotBlank String mesFin) {
		this.idExp = idExp;
		this.cargoExp = cargoExp;
		this.lugarExp = lugarExp;
		this.anioInicio = anioInicio;
		this.mesInicio = mesInicio;
		this.anioFin = anioFin;
		this.mesFin = mesFin;
	}






	public Long getIdExp() {
		return idExp;
	}



	public void setIdExp(Long idExp) {
		this.idExp = idExp;
	}



	public String getCargoExp() {
		return cargoExp;
	}



	public void setCargoExp(String cargoExp) {
		this.cargoExp = cargoExp;
	}



	public String getLugarExp() {
		return lugarExp;
	}



	public void setLugarExp(String lugarExp) {
		this.lugarExp = lugarExp;
	}



	public int getAnioInicio() {
		return anioInicio;
	}



	public void setAnioInicio(int anioInicio) {
		this.anioInicio = anioInicio;
	}



	public String getMesInicio() {
		return mesInicio;
	}



	public void setMesInicio(String mesInicio) {
		this.mesInicio = mesInicio;
	}



	public int getAnioFin() {
		return anioFin;
	}



	public void setAnioFin(int anioFin) {
		this.anioFin = anioFin;
	}



	public String getMesFin() {
		return mesFin;
	}



	public void setMesFin(String mesFin) {
		this.mesFin = mesFin;
	}
	
		

}
