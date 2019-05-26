package com.clubdeportivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clubdeportivo.model.DeporteModel;

@Repository
public interface DeporteRepositoryDao extends JpaRepository<DeporteModel,Integer> {

}
