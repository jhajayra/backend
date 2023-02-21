package com.jhajayramori.app.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhajayramori.app.security.entity.User;


public interface iUsuarioRepository extends JpaRepository<User, Integer>{
    Optional<User> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);

	
    

}
