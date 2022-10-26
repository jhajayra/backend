package com.jhajayramori.app.security.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhajayramori.app.security.dto.JwtDto;
import com.jhajayramori.app.security.dto.LoginUsuario;
import com.jhajayramori.app.security.dto.NuevoUsuario;
import com.jhajayramori.app.security.entity.Rol;
import com.jhajayramori.app.security.entity.User;
import com.jhajayramori.app.security.enums.RolNombre;
import com.jhajayramori.app.security.jwt.JwtProvider;
import com.jhajayramori.app.security.service.RolService;
import com.jhajayramori.app.security.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	RolService rolService;
	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/new")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity<>(new Mensaje("Campo mal ingresado o email no válido"), HttpStatus.BAD_REQUEST);

		if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
			return new ResponseEntity<>(new Mensaje("Nombre de usuario existente"), HttpStatus.BAD_REQUEST);

		if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
			return new ResponseEntity<>(new Mensaje("Email existente"), HttpStatus.BAD_REQUEST);

		User usuario = new User(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
				passwordEncoder.encode(nuevoUsuario.getPassword()));

		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

		if (nuevoUsuario.getRoles().contains("admin"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());

		usuario.setRoles(roles);
		usuarioService.save(usuario);
		return new ResponseEntity<>(new Mensaje("Usuario Creado Correctamente"), HttpStatus.CREATED);

	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {

		if (bindingResult.hasErrors())
			return new ResponseEntity<>(new Mensaje("Campos mal ingresados, verifique sus credenciales"),
					HttpStatus.BAD_REQUEST);

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateToken(authentication);

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

		return new ResponseEntity<>(jwtDto, HttpStatus.OK);

	}

	@GetMapping("/ver/{id}")
	public ResponseEntity<?> verUsuario(@PathVariable("id") int id) {
		User user = usuarioService.ver(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> actualizar(@PathVariable("id") int id, @Valid @RequestBody User usuario,
			BindingResult bindingResult) {

		User usuarioEditado = usuarioService.ver(id);

		if (usuarioEditado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		usuarioService.borrar(id);
		String nombre = "jhajayra";
		String email = "jhajayra95@gmail.com";
		User usuarioNuevo = new User(nombre, usuario.getNombreUsuario(), email,
				passwordEncoder.encode(usuario.getPassword()));

		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
		usuarioNuevo.setRoles(roles);

		usuarioService.save(usuarioNuevo);

		return new ResponseEntity<>(HttpStatus.OK);

	}
}