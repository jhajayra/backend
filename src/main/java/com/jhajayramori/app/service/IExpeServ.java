package com.jhajayramori.app.service;

import java.util.List;

import com.jhajayramori.app.model.Experiencia;

public interface IExpeServ {

	public Experiencia agregarExp(Experiencia experiencia);

    public Experiencia editarExp(Experiencia experiencia);

    public void borrarExp (Long id);

    public List <Experiencia> listaExp();

    public Experiencia buscarExp ( Long id);
    
}
