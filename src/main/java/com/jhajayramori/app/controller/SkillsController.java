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

import com.jhajayramori.app.model.Skills;
import com.jhajayramori.app.service.ISkillsServ;


@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {

	@Autowired
	ISkillsServ iskillServ;

	public SkillsController(ISkillsServ iskillServ) {
		this.iskillServ = iskillServ;
	}

	// CRUD
	@GetMapping("/list")
	public ResponseEntity<List<Skills>> verListaSkills() {
		List<Skills> skillsList = iskillServ.listaSkill();
		return new ResponseEntity<>(skillsList, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<?> verSkill(@PathVariable("id") Long id) {
		Skills skill = iskillServ.buscarSkill(id);
		if (skill == null) {
			return new ResponseEntity<>("Skill Not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(skill, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> actualizarSkill(@PathVariable("id") Long id, @RequestBody Skills skill) {
		if (iskillServ.buscarSkill(id) == null) {
			return new ResponseEntity<>("Skill Not Exist", HttpStatus.NOT_FOUND);
		}
		if (StringUtils.isBlank(skill.getNombreSkill())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Skills skillActual = iskillServ.editarSkill(skill);
		return new ResponseEntity<>(skillActual, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> crearSkill(@RequestBody Skills skill) {
		if (StringUtils.isBlank(skill.getNombreSkill())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Skills nuevaSkill = iskillServ.agregarSkill(skill);
		return new ResponseEntity<>(nuevaSkill, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> borrarProye(@PathVariable("id") Long id) {
		if (iskillServ.buscarSkill(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		iskillServ.borrarSkill(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}



	
	
	
	
	
}
