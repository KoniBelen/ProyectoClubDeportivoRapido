package com.clubdeportivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clubdeportivo.model.RecursosModel;

@Repository
public interface RecursosDao extends JpaRepository<RecursosModel, Integer> {

}
