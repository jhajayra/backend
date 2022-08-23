package com.jhajayramori.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhajayramori.app.model.Experiencia;
import com.jhajayramori.app.service.IExpeServ;


@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = "http://localhost:4200")
public class ExpeController {
	
	@Autowired
	IExpeServ  iexpeServ;

	public ExpeController(IExpeServ iexpeServ) {
		this.iexpeServ = iexpeServ;
	}
	
	@GetMapping("/list")
    public ResponseEntity<List<Experiencia>> verListaExperiencia(){
        List<Experiencia> experienciaList = iexpeServ.listaExp();
        return new ResponseEntity<>(experienciaList, HttpStatus.OK);
    }
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> verExperiencia(@PathVariable("id") Long id) {
		Experiencia experiencia = iexpeServ.buscarExp(id);
		if (experiencia == null) {
			return new ResponseEntity<>("Experience Not Found",HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(experiencia, HttpStatus.OK);  
	}
	
	
	 @PutMapping("/update/{id}")
	    public ResponseEntity<?> actualizarExp(@PathVariable("id") Long id, @RequestBody Experiencia experiencia){
		 if(iexpeServ.buscarExp(id)==null) {
		 		return new ResponseEntity<>("Experience Not Exist", HttpStatus.NOT_FOUND);
		 	}   
		 Experiencia expActual = iexpeServ.editarExp(experiencia);
	        return new ResponseEntity<>(expActual, HttpStatus.OK);
	    }
	 
	 @PostMapping("/create")
	    public ResponseEntity <?> crearExp(@RequestBody Experiencia experiencia){
	        Experiencia nuevaExp = iexpeServ.agregarExp(experiencia);
	        return new ResponseEntity<>(nuevaExp, HttpStatus.OK);
	    }
	 
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> borrarExp(@PathVariable("id") Long id){
	        if (iexpeServ.buscarExp(id)==null){
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        iexpeServ.borrarExp(id);
	        return  new ResponseEntity<>(HttpStatus.OK);
	    
	    }
	
	

}
