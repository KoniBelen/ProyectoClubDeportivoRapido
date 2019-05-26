package com.clubdeportivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clubdeportivo.model.CategoriaModel;

@Repository
public interface CategoriaDao extends JpaRepository<CategoriaModel, Integer> {

}
