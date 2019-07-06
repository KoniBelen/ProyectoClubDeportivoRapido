package com.clubdeportivo2.clubdeportivo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.clubdeportivo2.clubdeportivo.model.EquipoModel;


public interface EquipoDao extends CrudRepository<EquipoModel, Integer> {
	
List<EquipoModel> findByNombreEquipoLike(String valor);
	
	List<EquipoModel> findByNombreEquipo(String nombreEquipo);

}
