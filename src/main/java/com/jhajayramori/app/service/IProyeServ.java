package com.jhajayramori.app.service;

import java.util.List;

import com.jhajayramori.app.model.Proyectos;

public interface IProyeServ {

	  public Proyectos agregarProye ( Proyectos proyecto);

	    public Proyectos editarProye(Proyectos proyecto);

	    public void borrarProye(Long id);

	    public List <Proyectos> listaProye();

	    public Proyectos buscarProye(Long id);
}
