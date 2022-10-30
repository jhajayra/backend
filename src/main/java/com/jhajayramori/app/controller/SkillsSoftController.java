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

import com.jhajayramori.app.model.SoftSkills;
import com.jhajayramori.app.service.ISoftSkillsServ;

@RestController
@RequestMapping("/skillsSoft")
@CrossOrigin(origins = "https://jhajayra-mori.web.app")
public class SkillsSoftController {
	
	@Autowired
	ISoftSkillsServ isoftServ;

	public SkillsSoftController(ISoftSkillsServ isoftServ) {
		this.isoftServ = isoftServ;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<SoftSkills>> verListaSoft(){
		List <SoftSkills> softList = isoftServ.listaSoft();
		return new ResponseEntity<>(softList, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<?> verSoft(@PathVariable("id") Long id){
		SoftSkills soft = isoftServ.buscarSoft(id);
		if (soft == null ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(soft, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> actualizarSoft(@PathVariable("id") Long id, @RequestBody SoftSkills soft) {
		if (isoftServ.buscarSoft(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (StringUtils.isBlank(soft.getNombreSoft())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		SoftSkills softActual = isoftServ.editarSoft(soft);
		return new ResponseEntity<>(softActual, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> crearSoft(@RequestBody SoftSkills soft) {
		if (StringUtils.isBlank(soft.getNombreSoft())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		SoftSkills nuevaSoft = isoftServ.agregarSoft(soft);
		return new ResponseEntity<>(nuevaSoft, HttpStatus.OK);
	}

	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> borrarSoft(@PathVariable("id") Long id) {
		if (isoftServ.buscarSoft(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		isoftServ.borrarSoft(id) ;
		return new ResponseEntity<>(HttpStatus.OK);

	}
}
