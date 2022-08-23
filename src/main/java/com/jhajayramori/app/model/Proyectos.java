package com.jhajayramori.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos implements Serializable {

    
	private static final long serialVersionUID = -7373633395370740854L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProye;
    private String nombreProye;
    private  String descriProye;
    private int anioProye;

    public Proyectos (){

    }

    public Proyectos (Long idProye, String nombreProye, String descriProye, int anioProye) {
        this.idProye=idProye;
        this.nombreProye=nombreProye;
        this.descriProye=descriProye;
        this.anioProye=anioProye;
    }

	public Long getIdProye() {
		return idProye;
	}

	public void setIdProye(Long idProye) {
		this.idProye = idProye;
	}

	public String getNombreProye() {
		return nombreProye;
	}

	public void setNombreProye(String nombreProye) {
		this.nombreProye = nombreProye;
	}

	public String getDescriProye() {
		return descriProye;
	}

	public void setDescriProye(String descriProye) {
		this.descriProye = descriProye;
	}

	public int getAnioProye() {
		return anioProye;
	}

	public void setAnioProye(int anioProye) {
		this.anioProye = anioProye;
	}
    
    
    
}
