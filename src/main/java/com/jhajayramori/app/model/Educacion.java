package com.jhajayramori.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;




@Entity
public class Educacion implements Serializable {

    private static final long serialVersionUID = 2534050596279469059L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEdu;
    
    @NotNull
    private String tituloEdu;
    
    @NotNull
    private String lugarEdu;
    
    private int anioEdu;

    public Educacion(){
    }
    
    public Educacion (Long idEdu, String tituloEdu,int anioEdu, String lugarEdu ){
     
        this.idEdu = idEdu;
        this.tituloEdu = tituloEdu;
        this.anioEdu = anioEdu;        
        this.lugarEdu = lugarEdu;
    }

	public Long getIdEdu() {
		return idEdu;
	}

	public void setIdEdu(Long idEdu) {
		this.idEdu = idEdu;
	}

	public String getTituloEdu() {
		return tituloEdu;
	}

	public void setTituloEdu(String tituloEdu) {
		this.tituloEdu = tituloEdu;
	}

	public String getLugarEdu() {
		return lugarEdu;
	}

	public void setLugarEdu(String lugarEdu) {
		this.lugarEdu = lugarEdu;
	}

	public int getAnioEdu() {
		return anioEdu;
	}

	public void setAnioEdu(int anioEdu) {
		this.anioEdu = anioEdu;
	}
    
    
}
