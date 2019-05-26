package com.clubdeportivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clubdeportivo.model.EquipoModel;

@Repository
public interface EquipoDao extends JpaRepository <EquipoModel, Integer> {

}
