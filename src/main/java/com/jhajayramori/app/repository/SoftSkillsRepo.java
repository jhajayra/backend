package com.jhajayramori.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhajayramori.app.model.SoftSkills;

@Repository
public interface SoftSkillsRepo extends JpaRepository <SoftSkills, Long> {

}
