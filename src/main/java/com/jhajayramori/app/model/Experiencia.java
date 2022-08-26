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
	@Column(length = 30)
    private String cargoExp;
	
	@Column(length = 4)
    private int anioExp;
    
    @NotBlank
    @Column(length = 50)
    private String lugarExp;

    public Experiencia(){
    }
    
    public Experiencia (Long idExp, String cargoExp, int anioExp, String lugarExp ){
     
        this.idExp = idExp;
        this.cargoExp = cargoExp;
        this.lugarExp = lugarExp;
        this.anioExp = anioExp;        
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

	public int getAnioExp() {
		return anioExp;
	}

	public void setAnioExp(int anioExp) {
		this.anioExp = anioExp;
	}

	public String getLugarExp() {
		return lugarExp;
	}

	public void setLugarExp(String lugarExp) {
		this.lugarExp = lugarExp;
	}
    
    

    
}

