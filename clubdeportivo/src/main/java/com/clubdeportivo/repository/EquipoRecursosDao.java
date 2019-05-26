package com.clubdeportivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clubdeportivo.model.EquipoRecursoModel;

@Repository
public interface EquipoRecursosDao extends JpaRepository <EquipoRecursoModel, Integer>{

}
