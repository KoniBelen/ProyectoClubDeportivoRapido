package com.clubdeportivo2.clubdeportivo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.clubdeportivo2.clubdeportivo.model.CategoriaModel;
import com.clubdeportivo2.clubdeportivo.model.SocioModel;

public interface CategoriaDao extends CrudRepository<CategoriaModel, Integer> {
	
	List<CategoriaModel> findByNombreCategoria (String nombreCategoria);

}
