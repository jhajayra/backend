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

import com.jhajayramori.app.model.Educacion;
import com.jhajayramori.app.service.IEduServ;

@RestController
@RequestMapping("/education")
@CrossOrigin(origins = "http://localhost:4200/")
public class EduController {

	@Autowired
	IEduServ ieducaServ;

	public EduController(IEduServ ieducaServ) {
		this.ieducaServ = ieducaServ;
	}

	@GetMapping("/list")
	public ResponseEntity<List<Educacion>> verListaEducacion() {
		List<Educacion> educacionesList = ieducaServ.listaEdu();
		return new ResponseEntity<>(educacionesList, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<?> verEducacion(@PathVariable("id") Long id) {
		Educacion educacion = ieducaServ.buscarEdu(id);
		if (educacion == null) {
			return new ResponseEntity<>("Education Not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(educacion, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> actualizarEdu(@PathVariable("id") Long id, @RequestBody Educacion educacion) {
		if (ieducaServ.buscarEdu(id) == null) {
			return new ResponseEntity<>("Education Not Exist", HttpStatus.NOT_FOUND);
		}
		if (StringUtils.isAnyBlank(educacion.getTituloEdu(), educacion.getLugarEdu())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Educacion eduActual = ieducaServ.editarEdu(educacion);
		return new ResponseEntity<>(eduActual, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> crearEdu(@RequestBody Educacion educacion) {
		if (StringUtils.isAnyBlank(educacion.getTituloEdu(), educacion.getLugarEdu())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Educacion nuevaEdu = ieducaServ.agregarEdu(educacion);
		return new ResponseEntity<>(nuevaEdu, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> borrarEdu(@PathVariable("id") Long id) {
		if (ieducaServ.buscarEdu(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ieducaServ.borrarEdu(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
