package com.jhajayramori.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhajayramori.app.model.Usuario;

@Repository
public interface UsuarioRepo  extends JpaRepository < Usuario, Long > {

}
