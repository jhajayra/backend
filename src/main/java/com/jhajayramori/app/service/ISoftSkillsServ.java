package com.jhajayramori.app.service;

import java.util.List;

import com.jhajayramori.app.model.SoftSkills;

public interface ISoftSkillsServ {
	
	public List <SoftSkills> listaSoft();
	
	public SoftSkills agregarSoft(SoftSkills skillSoft);
	
	public SoftSkills editarSoft(SoftSkills skillSoft);
	
	public void borrarSoft(Long id);
	
	public SoftSkills buscarSoft(Long id);
	
	
	

}
