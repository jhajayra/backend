package com.jhajayramori.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhajayramori.app.model.Usuario;
import com.jhajayramori.app.service.IUsuarioServ;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioController {
   
   
	@Autowired
	IUsuarioServ iusuarioServ;
	
	public UsuarioController(IUsuarioServ iusuarioServ) {
	    this.iusuarioServ = iusuarioServ;
	}
	
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> obtenerUsuario(@PathVariable("id") Long id){
	    Usuario usuario = iusuarioServ.buscarUsuario(id);
	    if (usuario == null ) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(usuario, HttpStatus.OK);
	    }
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> actualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario){
		if(iusuarioServ.buscarUsuario(id)==null) {
	 		return new ResponseEntity<>("Project Not Exist", HttpStatus.NOT_FOUND);
	 	}
	    Usuario actualUsuario=iusuarioServ.editarUsuario(usuario);
	    return new ResponseEntity<>(actualUsuario, HttpStatus.OK);

	}


}
