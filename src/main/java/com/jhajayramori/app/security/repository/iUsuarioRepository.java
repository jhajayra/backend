package com.jhajayramori.app.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhajayramori.app.security.entity.User;


@Repository
public interface iUsuarioRepository extends JpaRepository<User, Integer>{
    Optional<User> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    

}
