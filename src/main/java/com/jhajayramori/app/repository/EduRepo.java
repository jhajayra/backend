package com.jhajayramori.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhajayramori.app.model.Educacion;

@Repository
public interface EduRepo extends JpaRepository <Educacion, Long>{

}
