package com.jhajayramori.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhajayramori.app.model.Experiencia;
import com.jhajayramori.app.repository.ExpeRepo;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ExpeServ implements IExpeServ{

    @Autowired
    private final ExpeRepo expeRepo;

    
    public ExpeServ(ExpeRepo expeRepo) {
        this.expeRepo = expeRepo;
    }

    @Override
    public List <Experiencia> listaExp(){
    	return expeRepo.findAll();
    }
    
    @Override
    public Experiencia buscarExp(Long id) {
    	return expeRepo.findById(id).orElse(null);
    }

   
    
    @Override
    public Experiencia agregarExp(Experiencia experiencia){
        return expeRepo.save(experiencia);
    }
    
    @Override
    public Experiencia editarExp(Experiencia experiencia){
        return expeRepo.save(experiencia);
    }
    
    @Override
    public void borrarExp (Long id) {
        expeRepo.deleteById(id);
        
    }
    





    
}