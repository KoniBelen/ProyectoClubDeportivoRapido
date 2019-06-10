package com.clubdeportivo2.clubdeportivo.service;

import java.util.List;

import com.clubdeportivo2.clubdeportivo.commons.GenericService;
import com.clubdeportivo2.clubdeportivo.model.CategoriaModel;
import com.clubdeportivo2.clubdeportivo.model.SocioModel;



public interface CategoriaService extends GenericService<CategoriaModel, Integer>

{

	List<CategoriaModel> findByNombreCategoria(String nombre);

}
