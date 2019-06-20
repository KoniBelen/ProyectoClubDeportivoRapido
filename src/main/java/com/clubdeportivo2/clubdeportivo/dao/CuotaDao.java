package com.clubdeportivo2.clubdeportivo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.clubdeportivo2.clubdeportivo.model.CuotasModel;
import com.clubdeportivo2.clubdeportivo.model.EquipoModel;

public interface CuotaDao extends CrudRepository<CuotasModel, Integer> {

}
