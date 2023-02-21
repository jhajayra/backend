package com.jhajayramori.app.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhajayramori.app.security.entity.Rol;
import com.jhajayramori.app.security.enums.RolNombre;



public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}