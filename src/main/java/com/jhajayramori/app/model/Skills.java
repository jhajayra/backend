package com.jhajayramori.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Skills implements Serializable {

   
	private static final long serialVersionUID = 106818120910907062L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSkill;
    private String nombreSkill;
    private int porcentaje;

    public Skills() {

    }

    public Skills(Long idSkill, String nombreSkill, int porcentaje) {
        this.idSkill=idSkill;
        this.nombreSkill=nombreSkill;
        this.porcentaje=porcentaje;
    }

	public Long getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(Long idSkill) {
		this.idSkill = idSkill;
	}

	public String getNombreSkill() {
		return nombreSkill;
	}

	public void setNombreSkill(String nombreSkill) {
		this.nombreSkill = nombreSkill;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
    
    
    
}
