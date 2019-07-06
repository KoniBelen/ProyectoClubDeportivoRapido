package com.clubdeportivo2.clubdeportivo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.clubdeportivo2.clubdeportivo.model.CategoriaModel;

public interface CategoriaDao extends CrudRepository<CategoriaModel, Integer> {
	
	
	List<CategoriaModel> findByNombreCategoriaLike(String valor);
	
	List<CategoriaModel> findByNombreCategoria(String nombreCategoria);

}
