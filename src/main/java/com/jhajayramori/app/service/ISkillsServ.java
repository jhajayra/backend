package com.jhajayramori.app.service;

import java.util.List;

import com.jhajayramori.app.model.Skills;

public interface ISkillsServ {

	public Skills agregarSkill(Skills skill);

    public Skills editarSkill(Skills skill);

    public void borrarSkill (Long id);

    public List <Skills> listaSkill();

    public Skills buscarSkill(Long id);
}
