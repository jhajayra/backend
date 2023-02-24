package com.jhajayramori.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhajayramori.app.model.Skills;

@Repository
public interface SkillsRepo extends JpaRepository < Skills, Long >{

}
