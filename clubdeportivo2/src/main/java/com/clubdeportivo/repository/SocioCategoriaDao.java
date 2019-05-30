package com.clubdeportivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.clubdeportivo.model.SocioCategoriaModel;

@Repository
public interface SocioCategoriaDao extends JpaRepository<SocioCategoriaModel,Integer> {

}
