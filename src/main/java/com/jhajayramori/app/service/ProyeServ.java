package com.jhajayramori.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhajayramori.app.model.Proyectos;
import com.jhajayramori.app.repository.ProyeRepo;



@Service
@Transactional
public class ProyeServ implements IProyeServ{

   
    @Autowired
    private final ProyeRepo proyeRepo;

    public ProyeServ(ProyeRepo proyeRepo) {
        this.proyeRepo = proyeRepo;
    }

    @Override
    public Proyectos agregarProye ( Proyectos proyecto) {
        return proyeRepo.save(proyecto);
    }
      
    @Override
    public Proyectos editarProye(Proyectos proyecto){
        return proyeRepo.save(proyecto);
    }
    
    @Override
    public void borrarProye(Long id) {
        proyeRepo.deleteById(id);

    }

     @Override
    public List<Proyectos> listaProye() {
        return proyeRepo.findAll();
    }
    @Override
    public Proyectos buscarProye(Long id) {
        return proyeRepo.findById(id).orElse(null);
    }
    
    
}
