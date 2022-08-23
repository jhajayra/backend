package com.jhajayramori.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhajayramori.app.model.Experiencia;

@Repository
public interface ExpeRepo extends JpaRepository <Experiencia, Long> {

}
