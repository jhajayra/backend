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
public class Educacion implements Serializable {

    private static final long serialVersionUID = 2534050596279469059L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEdu;
    
    @NotNull
    @NotBlank
    @Column(length = 50, unique = true)
    private String tituloEdu;
    
 
    @NotBlank
    @Column(length = 50)
    private String lugarEdu;
    
    @Column(length = 4)
    private int anioEdu;

    public Educacion(){
    }
    
    public Educacion(Long idEdu, @NotNull @NotBlank String tituloEdu, @NotBlank String lugarEdu, int anioEdu) {
		this.idEdu = idEdu;
		this.tituloEdu = tituloEdu;
		this.lugarEdu = lugarEdu;
		this.anioEdu = anioEdu;
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
