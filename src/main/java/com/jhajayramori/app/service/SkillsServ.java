package com.jhajayramori.app.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhajayramori.app.model.Skills;
import com.jhajayramori.app.repository.SkillsRepo;



@Service
@Transactional
public class SkillsServ implements ISkillsServ{

	    @Autowired
	    private final SkillsRepo skillsRepo;

	    public SkillsServ(SkillsRepo skillsRepo) {
	        this.skillsRepo = skillsRepo;
	    }
	   
	    @Override
	    public Skills agregarSkill(Skills skill){
	        return skillsRepo.save(skill);
	    }

	    @Override
	    public Skills editarSkill(Skills skill){
	        return skillsRepo.save(skill);
	    }
	    
	    @Override
	    public void borrarSkill (Long id) {
	        skillsRepo.deleteById(id);

	    }

	    @Override
	    public List <Skills> listaSkill(){
	        return skillsRepo.findAll();
	    }

	    @Override
	    public Skills buscarSkill(Long id) {
	        return skillsRepo.findById(id).orElse(null);
	    }
	    

	    
	}

