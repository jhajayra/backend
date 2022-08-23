package com.jhajayramori.app.service;

import java.util.List;


import com.jhajayramori.app.model.Educacion;

public interface IEduServ {

	public Educacion agregarEdu(Educacion educacion);

    public Educacion editarEdu(Educacion educacion);

    public void borrarEdu (Long id);

    public List <Educacion> listaEdu();

    public Educacion buscarEdu (Long id);
}
