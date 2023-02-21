package com.jhajayramori.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhajayramori.app.model.Usuario;

public interface UsuarioRepo  extends JpaRepository < Usuario, Long > {

}
