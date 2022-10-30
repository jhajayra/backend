package com.jhajayramori.app.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhajayramori.app.model.Proyectos;
import com.jhajayramori.app.service.IProyeServ;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "https://jhajayra-mori.web.app")
public class ProyeController {

	@Autowired
	IProyeServ iproyeServ;

	public ProyeController(IProyeServ iproyeServ) {
		this.iproyeServ = iproyeServ;
	}
	
	
	//CRUD
	
	@GetMapping("/list")
    public ResponseEntity<List<Proyectos>> verListaProyectos(){
        List<Proyectos> proyectosList = iproyeServ.listaProye();
        return new ResponseEntity<>(proyectosList, HttpStatus.OK);
    }
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> verExperiencia(@PathVariable("id") Long id) {
		Proyectos proyecto = iproyeServ.buscarProye(id);
		if (proyecto == null) {
			return new ResponseEntity<>("Project Not Found",HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(proyecto, HttpStatus.OK);  
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	 @PutMapping("/update/{id}")
	    public ResponseEntity<?> actualizarProye(@PathVariable("id") Long id, @RequestBody Proyectos proyecto){
		 	if(iproyeServ.buscarProye(id)==null) {
		 		return new ResponseEntity<>("Project Not Exist", HttpStatus.NOT_FOUND);
		 	}
		 	if (StringUtils.isAnyBlank(proyecto.getNombreProye(), proyecto.getDescriProye() ) ) {
	    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    		}
	        Proyectos proyeActual = iproyeServ.editarProye(proyecto);
	        return new ResponseEntity<>(proyeActual, HttpStatus.OK);
	    }
	 
	@PreAuthorize("hasRole('ADMIN')")
	 @PostMapping("/create")
	    public ResponseEntity <?> crearProye(@RequestBody Proyectos proyecto){
		 if (StringUtils.isAnyBlank(proyecto.getNombreProye(), proyecto.getDescriProye() ) ) {
	    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    		}
	        Proyectos nuevoProye = iproyeServ.agregarProye(proyecto);
	        return new ResponseEntity<>(nuevoProye, HttpStatus.OK);
	    }
	 
	@PreAuthorize("hasRole('ADMIN')")
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> borrarProye(@PathVariable("id") Long id){
	        if (iproyeServ.buscarProye(id)==null){
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        iproyeServ.borrarProye(id);
	        return  new ResponseEntity<>( HttpStatus.OK);
	    
	    }
	
	
}
