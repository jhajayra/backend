package com.jhajayramori.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhajayramori.app.model.Proyectos;

@Repository
public interface ProyeRepo extends JpaRepository < Proyectos, Long >{

}
