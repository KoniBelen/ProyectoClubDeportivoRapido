package com.clubdeportivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clubdeportivo.model.SocioModel;

@Repository
public interface SocioDao extends JpaRepository<SocioModel, Integer> {

}
