package com.clubdeportivo2.clubdeportivo.service;

import java.util.List;

import com.clubdeportivo2.clubdeportivo.commons.GenericService;

import com.clubdeportivo2.clubdeportivo.model.RecursoModel;
import com.clubdeportivo2.clubdeportivo.model.SocioModel;

public interface RecursoService extends GenericService<RecursoModel, Integer> {

	
	List<RecursoModel> findByNombreRecurso(String valor);

	List<RecursoModel> findByNombreRecursoLike(String valor);
}
